package other.current;

import org.junit.Test;

public class VolatileTest {
    public static volatile int race = 0;

    @Test
    public void test1() {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(() -> {
                for (int y = 0; y < 10; y++) {
                    race++;
                }
            });
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(race);
    }
}
