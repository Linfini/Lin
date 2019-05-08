package other.current;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    private int i = 0;
    private AtomicInteger atomicI = new AtomicInteger(0);

    private void count() {
        i++;
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean b = atomicI.compareAndSet(i, ++i);
            if (b) {
                break;
            }
        }
    }

    @Test
    public void testCountAndSafeCount() {
        List<Thread> threads = new ArrayList<>(600);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    count();
                    safeCount();

                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("unsafe:" + i);
        System.out.println("safe:" + atomicI);
    }
}
