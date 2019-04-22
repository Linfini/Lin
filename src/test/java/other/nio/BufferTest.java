package other.nio;


import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 参考 thinkinjava.nettest
 */
public class BufferTest {

    private boolean isSuccess;
    private Boolean isMySelf;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Boolean getMySelf() {
        return isMySelf;
    }

    public void setMySelf(Boolean mySelf) {
        isMySelf = mySelf;
    }

    /**
     * Buffer demo
     */
    public void test1() throws IOException {
        FileInputStream fin = new FileInputStream(new File("D:\\temp_bugger.temp"));
        FileChannel fc = fin.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fc.read(byteBuffer);
        fc.close();
        byteBuffer.flip();
    }

    /**
     * nio 拷贝文件的 demo
     */
    public void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel readChannel = fis.getChannel(); //读文件通道
        FileChannel writeChannel = fos.getChannel(); //写文件通道

        ByteBuffer buffer = ByteBuffer.allocate(1024); //字节缓存大小1024
        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer);
            if (len == -1) {
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    /**
     * Buffer三个参数
     *
     * position 读写的位置
     * capacity 读/写总容量不变
     * limit 总是上次写入的position
     */
    @Test
    public void bufferParam() {
        ByteBuffer buffer = ByteBuffer.allocate(15); //字节缓存大小15
        System.out.println("默认 "+"limit=" + buffer.limit() + " capacity=" + buffer.capacity() +
                " position=" + buffer.position());
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        System.out.println("写10 "+"limit=" + buffer.limit() + " capacity=" + buffer.capacity() +
                " position=" + buffer.position());

        buffer.flip();
        System.out.println("重置 "+"limit=" + buffer.limit() + " capacity=" + buffer.capacity() + " position=" + buffer.position());
        for(int i=0;i<5;i++){
            System.out.print(buffer.get());
        }
        System.out.println();
        System.out.println("读5 limit=" + buffer.limit() + " capacity=" + buffer.capacity() + " position=" + buffer.position());

        buffer.flip();
        System.out.println("重置 limit=" + buffer.limit() + " capacity=" + buffer.capacity() + " position=" + buffer.position());
    }

}
