package com.zaki;

import java.io.*;

/**
 * main方法会加载 G:\worpspace\lin\classloader\target\classes\com\zaki 路径下的DemoObj.class文件.
 * 为什么要实现自定义类加载器:
 * 当class文件不在classPath路径地下的时候,我们可以自由选择路径,如本例所示
 * 当class文件通过网络传输的时候
 * 当需要实现热部署,同一个class文件通过不同的类加载器产生不同的对象二实现热部署,直接调用findClass绕过检查已加载.一个类加载器实例和同一个class文件只能被加载一次
 * */
public class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] classData = new byte[0];
        try {
            classData = getClassData(name);
        } catch (IOException e) {
            return super.loadClass(name);
        }
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) throws IOException {
        String path = classNameToPath(className);
        FileInputStream ins = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bufferSize = 4096;
        byte[] buffer = new byte[bufferSize];
        int bytesNumRead = 0;
        while ((bytesNumRead = ins.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesNumRead);
        }
        return baos.toByteArray();

    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar + className.replace(".", File.separator) + ".class";
    }

    public static void main(String[] args) {
        String rootDir = "G:\\worpspace\\lin\\classloader\\target\\classes";
        FileClassLoader loader = new FileClassLoader(rootDir);
        try {
            Class<?> obj = loader.loadClass("com.zaki.DemoObj");
            System.out.println(obj.newInstance().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
