package com.zaki.ThreadTest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileCountTest {
     private static int count = 1;
     private volatile static int volatileCount = 1;
     private static int synchronizedCount = 1;
     private static AtomicInteger atomicCount = new AtomicInteger(1);

    @Test
    public void test1() throws InterruptedException {

        final Object lock = new Object();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                count++;
                volatileCount++;
                synchronized (lock) {
                    synchronizedCount++;
                }
                atomicCount.incrementAndGet();
            }).start();

            Thread.sleep(2000);
        }


        System.out.println("线程并发执行对计数器累计5000次，看并发结果！");
        System.out.println("count=" + count);
        System.out.println("volatileCount=" + volatileCount);
        System.out.println("synchronizedCount=" + synchronizedCount);
        System.out.println("atomicCount=" + atomicCount.get());

    }
}