package other.threaddemo;

import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

public class InterruptedDemo {

    /**
     * 理解中断: 抛出InterruptedException的方法.这里就是freeThread回在抛出异常之前将中断标识位重置,所以中断标识位为false
     * */
    @Test
    public void test1() throws InterruptedException {
        Thread freeThread = new Thread(() -> {
            while (true) {
                SleepUtils.second(10);
            }
        }, "freeThread");
        freeThread.setDaemon(true);
        Thread busyThread = new Thread(() -> {
            while (true) {

            }
        }, "busyThread");
        busyThread.setDaemon(true);

        freeThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        freeThread.interrupt();
        busyThread.interrupt();

        System.out.println("freeThread interrupted is:" + freeThread.isInterrupted());
        System.out.println("busyThread interrupted is:" + busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }


    /**
     * 如何安全的中止线程
     * 可以使用中断或者一个标识位变量来决定是否要停止任务
     * */
}
