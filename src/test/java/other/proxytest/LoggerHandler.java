package other.proxytest;

import org.slf4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerHandler implements InvocationHandler {

    private Object target;

    public LoggerHandler() {
    }

    public LoggerHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("doSomething begin...");
        Object invoke = method.invoke(target, args);
        System.out.println("doSomething end...");
        return invoke;
    }
}
