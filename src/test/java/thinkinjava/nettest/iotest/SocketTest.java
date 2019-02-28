package thinkinjava.nettest.iotest;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;


public class SocketTest {
    public static int DEFAULT_PORT = 7;

    /**
     * 这种单线程,不能支持两个客户端同时发送消息,当client1阻塞的时候,服务器啥都干不了
     */
    @Test
    public void service() throws IOException {
        ServerSocket serverSocket = new ServerSocket(10241);
        while (true) {
            Socket socket = null;
            try {
                System.out.println("准备建立连接..");
                socket = serverSocket.accept();
                System.out.println("new connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("客户端:" + br.readLine());

                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);//获得socket输出流,并将之包装成PrintWriter
                pw.println("this server");//服务端的处理逻辑,将client发来的数据原封不动再发给client
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void client1() throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 10241);
            long millis1 = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
            }
            long millis2 = System.currentTimeMillis();
            System.out.println("阻塞时间:" + String.valueOf(millis2 - millis1));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("你好 我是客户端1+" + String.valueOf(millis2 - millis1));

            //客户端读取数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = br.readLine();
            System.out.println("服务器:" + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client2() throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 10241);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("你好 我是客户端2!");

            //客户端读取数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = br.readLine();
            System.out.println("服务器:" + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 不论client建立多少次,server只建立一个阻塞也就是一个TCP连接 胡说
     * 每个client都会建立一个socket(TCP连接)
     * 使用多线程,完美角色客户端1阻塞问题
     * 但是线程没法复用....不停的创建销毁显然不合理,可以看到,线程名称发生变化
     */
    @Test
    public void multipartThreadServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(10241);
        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println("this is server..");
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("客户端:" + br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    /**
     * 阻塞式+线程池模型 重用线程避免了频率地创建和销毁线程带来的开销。
     */
    @Test
    public void threadPoolServer() throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(10241);
        while (true) {
            Socket socket = serverSocket.accept();
            threadPool.submit(new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println("this is server..");
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("客户端:" + br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
    /**
     * NIO 模型 Selector解决并发量过大损耗服务器性能的问题
     * <p>
     * 用主线程(一个线程/等同CPU核心线程数)保持住所有连接,管理和读取客户端连接的数据,将读取后的数据交给后面的线程池处理,线程池处理完业务逻辑之后
     * 将结果交给主线程发送给给客户端,少量线程就可以处理大量连接请求.
     * Channel Buffer Selector NIO核心
     */
    @Test
    public void nonBlockingServer() throws IOException {
        ServerSocketChannel serverChannel;
        Selector selector = null;
        try {
            serverChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress(10241);
            serverChannel.bind(address);
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("accepted connected from" + client);
                        client.configureBlocking(false);
                        SelectionKey clientKey = client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        clientKey.attach(buffer);
                    }

                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output);
                    }

                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        client.write(output);
                        output.compact();
                    }
                } catch (Exception e) {
                    key.channel();
                    key.channel().close();
                }
            }
        }
    }


    /**
     * aio 暂时先不看
     * */
    public void aioTest(String[] args) throws IOException {
        int port;

        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }

        ExecutorService taskExecutor = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        // create asynchronous server socket channel bound to the default group
        try (AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open()) {
            if (asynchronousServerSocketChannel.isOpen()) {
                // set some options
                asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
                // bind the server socket channel to local address
                asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
                // display a waiting message while ... waiting clients
                System.out.println("Waiting for connections ...");
                while (true) {
                    Future<AsynchronousSocketChannel> asynchronousSocketChannelFuture = asynchronousServerSocketChannel
                            .accept();
                    try {
                        final AsynchronousSocketChannel asynchronousSocketChannel = asynchronousSocketChannelFuture
                                .get();
                        Callable<String> worker = new Callable<String>() {
                            @Override
                            public String call() throws Exception {
                                String host = asynchronousSocketChannel.getRemoteAddress().toString();
                                System.out.println("Incoming connection from: " + host);
                                final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                                // transmitting data
                                while (asynchronousSocketChannel.read(buffer).get() != -1) {
                                    buffer.flip();
                                    asynchronousSocketChannel.write(buffer).get();
                                    if (buffer.hasRemaining()) {
                                        buffer.compact();
                                    } else {
                                        buffer.clear();
                                    }
                                }
                                asynchronousSocketChannel.close();
                                System.out.println(host + " was successfully served!");
                                return host;
                            }
                        };
                        taskExecutor.submit(worker);
                    } catch (InterruptedException | ExecutionException ex) {
                        System.err.println(ex);
                        System.err.println("\n Server is shutting down ...");
                        // this will make the executor accept no new threads
                        // and finish all existing threads in the queue
                        taskExecutor.shutdown();
                        // wait until all threads are finished
                        while (!taskExecutor.isTerminated()) {
                        }
                        break;
                    }
                }
            } else {
                System.out.println("The asynchronous server-socket channel cannot be opened!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

