package com.zaki;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 一个简单的网络类加载器
 */
public class NetClassLoader extends ClassLoader {
    private String url;

    public NetClassLoader(String url) {
        this.url = url;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = new byte[0];
        try {
            classData = getClassDateFromNet(name);
        } catch (IOException e) {
            return super.loadClass(name);
        }
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassDateFromNet(String className) throws IOException {
        String path = classNameToPath(className);
        URL url = new URL(path);
        InputStream ins = url.openStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bufferSize = 4096;
        byte[] buffer = new byte[bufferSize];
        int bytesNumRead = 0;
        while ((bytesNumRead = ins.read()) != -1) {
            baos.write(buffer, 0, bytesNumRead);
        }
        return baos.toByteArray();
    }

    private String classNameToPath(String className) {
        return url + "/" + className.replace(".", "/") + ".class";
    }
}
