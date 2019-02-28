package other.nio;

import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;
import java.nio.channels.Selector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadNIOEchoServer {
    public static Map<Socket, Long> geym_time_stat = new HashMap<Socket, Long>();

    class EchoClient {
        private LinkedList<ByteBuffer> outq;

        EchoClient() {
            outq = new LinkedList<ByteBuffer>();
        }

        public LinkedList<ByteBuffer> getOutputQueue() {
            return outq;
        }

        public void enqueue(ByteBuffer bb) {
            outq.addFirst(bb);
        }
    }

    class HandleMsg implements Runnable {
        SelectionKey sk;
        ByteBuffer bb;

        public HandleMsg(SelectionKey sk, ByteBuffer bb) {
            super();
            this.sk = sk;
            this.bb = bb;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) sk.attachment();
            echoClient.enqueue(bb);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }

    private Selector selector;
    private ExecutorService tp = Executors.newCachedThreadPool();

    private void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        InetSocketAddress isa = new InetSocketAddress(10241);
        ssc.socket().bind(isa);

        ssc.register(selector, SelectionKey.OP_ACCEPT);
        for (; ; ) {
            selector.select();
            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> i = readKeys.iterator();
            long e = 0;
            while (i.hasNext()) {
                SelectionKey sk = i.next();
                i.remove();
                if (sk.isAcceptable()) {
                    doAccept(sk);
                } else if (sk.isValid() && sk.isReadable()) {
                    if (!geym_time_stat.containsKey(((SocketChannel) sk.channel()).socket())) {
                        geym_time_stat.put(((SocketChannel) sk.channel()).socket(), System.currentTimeMillis());
                    }
                    doRead(sk);
                } else if (sk.isValid() && sk.isWritable()) {
                    doWriter(sk);
                    e = System.currentTimeMillis();
                    long b = geym_time_stat.remove(((SocketChannel) sk
                            .channel()).socket());
                    System.out.println("spend:" + (e - b) + "ms");
                }
            }
        }
    }

    private void doWriter(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        int len;
        try {
            len = channel.read(bb);
            if (len < 0) {
                disconnect(sk);
                return;
            }
        } catch (IOException e) {
            disconnect(sk);
            return;
        }
        bb.flip();
        tp.execute(new HandleMsg(sk, bb));
    }

    private void disconnect(SelectionKey sk) {
        //断开连接
        SocketChannel channel = (SocketChannel) sk.channel();
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doRead(SelectionKey sk) {
        SocketChannel channel = (SocketChannel) sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        int len;
        try {
            len = channel.read(bb);
            if (len < 0) {
                disconnect(sk);
                return;
            }
        } catch (IOException e) {
            disconnect(sk);
            e.printStackTrace();
        }
        bb.flip();
        tp.execute(new HandleMsg(sk, bb));
    }

    private void doAccept(SelectionKey sk) {
        ServerSocketChannel server = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel;

        try {
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);
            SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ);

            EchoClient echoClient = new EchoClient();
            clientKey.attach(echoClient);
            InetAddress clientAddress = clientChannel.socket().getInetAddress();
            System.out.println("Accepted connection from " + clientAddress.getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        MultiThreadNIOEchoServer echoServer = new MultiThreadNIOEchoServer();
        try {
            echoServer.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
