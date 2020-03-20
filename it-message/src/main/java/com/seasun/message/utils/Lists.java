package com.seasun.message.utils;

import org.springframework.util.Assert;

import java.util.*;

public class Lists {
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    public static <E> ArrayList<E> newArrayList(E... elements) {
        Assert.notNull(elements,"elements not be null");
        ArrayList<E> list = new ArrayList<E>();
        Collections.addAll(list, elements);
        return list;
    }

    public static <V> List<V> toList(Iterable<V> iterable) {
        List<V> res = new ArrayList<>();
        for (V v : iterable) {
            res.add(v);
        }
        return res;
    }
}
