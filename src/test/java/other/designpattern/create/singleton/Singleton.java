package other.designpattern.create.singleton;

/**
 * 单例模式
 * 保证一个类只有一个实例
 * 关键代码:构造方法私有
 *
 * 以下为懒汉式
 * 饿汉式 :private static Singleton instance = new Singleton();
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }
}
