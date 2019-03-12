package other.designpattern.action.observer;

import org.junit.Test;
/**
 * 观察者模式 概念很好理解,一个对象的改变要通知到其他对象
 * 被观察者核心代码一个线程安全的容器,增加/删除观察者的方法 再业务逻辑种调用
 * */
public class Client {

    @Test
    public void test() {
        Subject sub = new ConcreteSubject();
        sub.addObserver(new ConcreteObserver1());
        sub.addObserver(new ConcreteObserver2());
        sub.doSomething();
    }
}
