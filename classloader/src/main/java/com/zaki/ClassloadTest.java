package com.zaki;

import java.net.URLClassLoader;

/**
 *
 * 这个测试说明了如下几个问题:
 * 系统的默认类加载器是AppClassloader,Launcher.getLauncher()
 * AppClassloader的父类加载器是ExtClassLoader,而ExtClassLoader的父类加载器为null
 * 自定义的类加载器的父类加载器都是AppClassLoader 因为ClassLoader构造器默认吧AppClassLoader作为系统父类构造器
 *
 * */
public class ClassloadTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        FileClassLoader loader = new FileClassLoader("D://");
        System.out.println(loader.getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
