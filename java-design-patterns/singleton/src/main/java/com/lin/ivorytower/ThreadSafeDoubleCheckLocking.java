package com.lin.ivorytower;

public final class ThreadSafeDoubleCheckLocking {
    private static volatile ThreadSafeDoubleCheckLocking instance;

    private static boolean flag = true;

    private ThreadSafeDoubleCheckLocking() {
        if (flag) {
            flag = false;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static ThreadSafeDoubleCheckLocking getInstance() {
        var result = instance;
        if (result == null) {
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
