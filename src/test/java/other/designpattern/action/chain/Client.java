package other.designpattern.action.chain;

import org.junit.Test;


/**
 * 责任链模式
 * 理解设设计模式的时候最好还是要弄清楚是谁在解耦,在这个例子种Handler提供的handlerRequest()为调用者提供请求对象和相应对象的解耦,调用者是需要请求对象参数交给Handler,handler会找到相应的处理器
 * */
public class Client {

    @Test
    public void test() {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        Response response = handler1.handleRequest(new Request(new Level(5)));
    }
}
