package com.zaki.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ClassUtils {

    /**
     * 获取给定类及其父类所有字段
     *
     * @param clazz           获取该类字段
     * @param annotationClazz 获取使用该注解的字段
     * @return 返回字段集合
     */
    public static <T> List<Field> getAllFields(Class<? super T> clazz, Class<? extends Annotation> annotationClazz) {
        List<Field> allFields = new ArrayList<>();
        while (null != clazz) {
            Field[] fields = clazz.getDeclaredFields();
            allFields.addAll(Arrays.asList(fields));
            clazz = clazz.getSuperclass();
        }
        if (annotationClazz == null) {
            return allFields;
        }
        List<Field> sortedFields = new ArrayList<>();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(annotationClazz)) {
                Annotation annotation = field.getAnnotation(annotationClazz);
                try {
                    Method sortMethod = annotationClazz.getMethod("sort");
                    int sort = (int) sortMethod.invoke(annotation);
                    addAndSort(sortedFields, field, sort, annotationClazz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sortedFields;
    }

    private static void addAndSort(List<Field> sortedFields, Field field, int sort, Class<? extends Annotation> annotationClazz) {
        for (int i = 0; i < sortedFields.size(); i++) {
            Annotation annotation = sortedFields.get(i).getAnnotation(annotationClazz);
            Method sortMethod;
            int oldSort;
            try {
                sortMethod = annotationClazz.getMethod("sort");
                oldSort = (int) sortMethod.invoke(annotation);
            } catch (Exception e) {
                throw new RuntimeException("获取方法失败..");
            }
            sortedFields.add(sort < oldSort ? i : i + 1, field);
            break;
        }
        if (sortedFields.isEmpty()) {
            sortedFields.add(field);
        }
    }

    public static <T> List<Field> getAllFields(Class<? super T> clazz, Class<? extends Annotation> annotationClazz, Boolean ascFlag) {
        List<Field> allFields = new ArrayList<>();
        while (null != clazz) {
            Field[] fields = clazz.getDeclaredFields();
            allFields.addAll(Arrays.asList(fields));
            clazz = clazz.getSuperclass();
        }
        if (annotationClazz == null) {
            return allFields;
        }
        allFields.removeIf(field -> !field.isAnnotationPresent(annotationClazz));
        if (ascFlag) {
            allFields.sort(Comparator.comparing(o -> getSort(o, annotationClazz)));
        } else {
            allFields.sort(Comparator.comparing((Field o) -> getSort(o, annotationClazz)).reversed());
        }
        return allFields;
    }

    public static Integer getSort(Field field, Class<? extends Annotation> annotationClazz) {
        Annotation annotation = field.getAnnotation(annotationClazz);
        int sort;
        try {
            Method sortMethod = annotationClazz.getMethod("sort");
            sort = (int) sortMethod.invoke(annotation);
        } catch (Exception e) {
            throw new RuntimeException("获取方法名失败");
        }
        return sort;
    }
}
