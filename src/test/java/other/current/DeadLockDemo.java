package other.current;

public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    private void deadLock() {
        Thread thread1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1获取A锁的业务逻辑");
                synchronized (B) {
                    System.out.println("线程1获取B锁的业务逻辑");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (B) {
                System.out.println("线程2获取B锁逻辑");
                synchronized (A) {
                    System.out.println("线程2获取A锁逻辑");
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
