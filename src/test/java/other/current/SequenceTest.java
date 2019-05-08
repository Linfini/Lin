package other.current;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceTest {
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * compareAndSet CAS原子操作
     */
    public void next() {
        while (true) {
            int current = count.get();
            int next = current + 1;
            if (count.compareAndSet(current, next)) {
                System.out.println(next);
            }
        }
    }
}
