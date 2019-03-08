package com.zaki.test;

public class Sub {
    private static int a = 2;

    public Sub() {
        System.out.println("a =" + a);
        System.out.println("b =" + b);
    }
    private static Sub sub = new Sub();

    private int b = 3;

    public static void main(String[] args) {

    }
}
