package com.zaki.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * 删除文件
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) return flag;
        if (!file.isDirectory()) return flag;

        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            temp = path.endsWith(File.separator) == true ? new File(path + tempList[i]) : new File(path + File.separator + tempList[i]);
            if (temp.isFile()) temp.delete();
            if (temp.isDirectory()) {
                delAllFile(path + File.separator + tempList[i]);
                delFolder(path + File.separator + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 删除文件夹
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath);
            new File(folderPath).delete();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除文件失败");
        }
    }

    /**
     * 显示所有子目录
     */
    public static List<String> showFilePath(String path, List<String> directoryList) {

        File file = new File(path);
        if (!file.exists())
            throw new RuntimeException("文件路径不存在");
        if (file.isFile())
            directoryList.add(path);

        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String absolutePath = files[i].getAbsolutePath();
            showFilePath(absolutePath, directoryList);
        }
        return directoryList;
    }


    public static void main(String[] args) {
        String path = "G:\\test";
        ArrayList<String> strings = new ArrayList<>();
        List<String> strings1 = showFilePath(path, strings);
        System.out.println(strings1);
    }
}
