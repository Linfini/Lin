package com.seasun.message.tx;

import java.util.ArrayList;
import java.util.List;

public class MessageContext {

    private List<Object> context = new ArrayList<>();

    public <T> void addContext(T instance) {
        context.add(instance);
    }

    public <T> T getContext(Class<T> clazz) {
        for (Object o : context) {
            if (clazz.equals(o.getClass())) {
                return (T) o;
            }
        }
        throw new IllegalArgumentException("为找到注册的类型");
    }
}
