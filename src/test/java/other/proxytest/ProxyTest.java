package other.proxytest;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    /**
     * 可以参考设计模式中代理模式
     *
     * jdk动态代理,1.动态代理比代理好的地方在于可以LoggerHandler构造方法是Object,也就是说可以代理任何类
     * 2.最最最最最扯淡的是动态代理要求的业务类必须有一个接口 对应的李
     */
    @Test
    public void test1() {
        IHelloWorld helloWorld = new HelloWorld();
        LoggerHandler handler = new LoggerHandler(helloWorld);
        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), helloWorld.getClass().getInterfaces(), handler);
        proxy.sayHello();
    }

    //普通代理,new HelloWorldProxy(new HelloWorld());这样写好像不是严格代理模式
    @Test
    public void test2() {
        HelloWorldProxy proxy = new HelloWorldProxy(new HelloWorld());
        proxy.sayHello();
    }

}
