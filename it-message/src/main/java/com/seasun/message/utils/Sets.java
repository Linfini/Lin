package com.seasun.message.utils;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <V> Set<V> toSet(Iterable<V> iterable) {
        HashSet<V> res = new HashSet<>();
        for (V v : iterable) {
            res.add(v);
        }
        return res;
    }
}
