package com.zaki.optionalTest;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

    @Test
    public void test1() {
        Outer outer = new Outer();
        Nested nested = outer.getNested();
        Inner inner = nested.getInner();
        String foo = inner.getFoo();
        System.out.println(foo);
    }

    @Test
    public void test2() {
        Outer outer = new Outer();
        if (null != outer && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        } else {
            System.out.println("some object is null");
        }
    }

    @Test
    public void test3() {
        Outer outer = new Outer();
        Optional.of(outer).map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo).ifPresent(System.out::println);
    }

    @Test
    public void test4() {
        Outer outer = new Outer();
        Optional<String> resolve = resolve(() -> outer.getNested().getInner().getFoo());
        resolve.ifPresent(System.out::println);
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            return Optional.ofNullable(resolver.get());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
