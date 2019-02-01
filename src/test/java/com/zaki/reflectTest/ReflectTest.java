package com.zaki.reflectTest;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectTest {
    @Test
    //获取字类以其父类的所有私有字段
    public void test1() {
        List<Field> allFields = new ArrayList<>();
        Class<?> currentClazz = Student.class;
        while (null != currentClazz) {
            allFields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            currentClazz = currentClazz.getSuperclass();
        }
        System.out.println(allFields);
    }

    /**
     *
     */
    @Test
    public void test2() {
        //输入 currentClazz List<T> body
        Class<?> currentClazz = Student.class;
        List<Field> allFields = new ArrayList<>();
        while (null != currentClazz) {
            allFields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            currentClazz = currentClazz.getSuperclass();
        }

        Set<String> heads = new LinkedHashSet<>();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(ExcelColumn.class)) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                heads.add(excelColumn.value());
            }
        }
        System.out.println(heads);
    }

    /**
     * 1.将Clazz中解析成为列名称,列名使用@ExcelColumn value值
     * 2.获取List<Student> 中的值作为excel的列名称
     */
    @Test
    public void test3() {
        //输入 currentClazz List<T> body
        Class<?> currentClazz = Student.class;
        List<Field> allFields = new ArrayList<>();
        while (null != currentClazz) {
            allFields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            currentClazz = currentClazz.getSuperclass();
        }

        List<Student> students = new ArrayList<>();
        Student student1 = new Student(100, "小学");
        student1.setCode("001");
        Student student2 = new Student(60, "中学");
        student2.setCode("002");
        students.add(student1);
        students.add(student2);

        Set<Set<String>> allColumnValues = new LinkedHashSet<>();
        for (Student student : students) {
            Set<String> columnValues = new LinkedHashSet<>();
            for (Field field : allFields) {
                if (field.isAnnotationPresent(ExcelColumn.class)) {
                    field.setAccessible(true);
                    try {
                        String value = field.get(student).toString();
                        columnValues.add(value);
                    } catch (IllegalAccessException ignored) {
                    }
                }
            }
            allColumnValues.add(columnValues);
        }
        Set<String> heads = new LinkedHashSet<>();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(ExcelColumn.class)) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                heads.add(excelColumn.value());
            }
        }
        System.out.println(Arrays.toString(heads.toArray()));
        System.out.println(Arrays.toString(allColumnValues.toArray()));
    }

    /**
     * 1.将Clazz中解析成为列名称,列名使用@ExcelColumn value值
     * 2.获取List<Student> 中的值作为excel的列名称
     * 3.在@ExcelColumn中使用注解
     */
    @Test
    public void test4() {
        //输入 currentClazz List<T> body
        Class<?> currentClazz = Student.class;
        List<Field> allFields = new ArrayList<>();
        while (null != currentClazz) {
            allFields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            currentClazz = currentClazz.getSuperclass();
        }
        //todo 根据sort给AllFields 排序
        Set<ReflectHelper> reflectHelpers = new LinkedHashSet<>();
        for (Field field : allFields) {
            ReflectHelper reflectHelper = new ReflectHelper();
            boolean annotationPresent = field.isAnnotationPresent(ExcelColumn.class);
            if (annotationPresent) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                reflectHelper.setSort(excelColumn.sort());
                reflectHelper.setField(field);
                reflectHelpers.add(reflectHelper);
            }
        }
        if (reflectHelpers.isEmpty()) {
            throw new RuntimeException("没有获取到特定属性..");
        }
        Set<Field> allFieldNames = reflectHelpers.stream().sorted(Comparator.comparing(ReflectHelper::getSort)).map(ReflectHelper::getField).collect(Collectors.toSet());
        System.out.println(allFieldNames);
    }

    /**
     * 获取给定类及其父类所有字段
     *
     * @param currentClazz    获取该类字段
     * @param annotationClazz 获取使用该注解的字段
     * @return 返回字段集合
     */
    public static <T, U extends Annotation> List<Field> getAllFields(Class<? super T> currentClazz, Class<U> annotationClazz) {
        List<Field> allFields = new ArrayList<>();
        while (null != currentClazz) {
            allFields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            currentClazz = currentClazz.getSuperclass();
        }

        List<ReflectHelper> reflectHelpers = new ArrayList<>();
        for (Field field : allFields) {
            if (annotationClazz == null) {
                reflectHelpers.add(new ReflectHelper(0, field));
            } else if (field.isAnnotationPresent(annotationClazz)) {
                U annotation = field.getAnnotation(annotationClazz);
                try {
                    Method sortMethod = annotationClazz.getMethod("sort");
                    int sort = (int) sortMethod.invoke(annotation);
                    reflectHelpers.add(new ReflectHelper(sort, field));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (reflectHelpers.isEmpty()) {
            return Collections.emptyList();
        }
        return reflectHelpers.stream().sorted(Comparator.comparing(ReflectHelper::getSort)).map(ReflectHelper::getField).collect(Collectors.toList());
    }

    /**
     * 创建Excel
     *
     * @param path  文件路径
     * @param clazz Excel文件第一列名称
     * @param body  表格数据
     */
    public static <T> void createExcel(String path, Class<T> clazz, List<T> body) {
        List<Field> allFields = getAllFields(clazz, ExcelColumn.class);
        if (allFields.isEmpty()) {
            throw new RuntimeException("没有获取到@ExcelHelper...,创建表格失败...");
        }
        Set<String> heads = new LinkedHashSet<>();
        for (Field field : allFields) {
            if (!field.isAnnotationPresent(ExcelColumn.class)) {
                throw new RuntimeException("获取字段错误");
            }
            ExcelColumn excelHelper = field.getAnnotation(ExcelColumn.class);
            heads.add(excelHelper.value());
        }

        List<List<String>> allColumn = new LinkedList<>();
        for (T t : body) {
            List<String> columns = new LinkedList<>();
            for (Field field : allFields) {
                field.setAccessible(true);
                try {
                    String value = field.get(t).toString();
                    columns.add(value);
                } catch (IllegalAccessException ignored) {
                }
            }
            allColumn.add(columns);
        }
        String[] headers = heads.toArray(new String[0]);
        String[][] records = allColumn.stream().map(v -> v.toArray(new String[0])).toArray(String[][]::new);

    }
}
