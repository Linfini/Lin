package other.designpatterntest.proxytest;

import org.junit.Test;

public class ProxyTest {


    /**
     * 代理模式中类的关系不需要客户端去配置，客户只需要使用代理类就ok了。
     * 但是装饰者模式中，类之间的关系需要客户指定。需要看自己是开发者还是客户
     *
     *
     * */
    @Test
    public void test1() {
        ProxySinger proxySinger = new ProxySinger("张学友");
        proxySinger.execute();
    }
}
