package com.zaki.utils;

import com.zaki.exception.NotFountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@SuppressWarnings({"unused", "WeakerAccess"})
@Slf4j
public class ClassUtils {

    /**
     * 获取目标类指定注解的Field集合
     *
     * @param currentClazz    目标类
     * @param annotationClazz 指定注解,nullable
     * @return 返回字段集合
     */
    public static <T, U extends Annotation> List<Field> getAllFields(Class<? super T> currentClazz, Class<U> annotationClazz) {
        Assert.notNull(currentClazz, "currentClazz 不能为空");

        List<Field> allFields = new ArrayList<>();
        while (null != currentClazz) {
            allFields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            currentClazz = currentClazz.getSuperclass();
        }
        if (annotationClazz == null) {
            return allFields;
        }
        allFields.removeIf(field -> !field.isAnnotationPresent(annotationClazz));
        return allFields;
    }

    /**
     * 获取目标类指定注解的Field集合,当annotaion注解中包含返回类型为int 的sort方法
     *
     * @param clazz           目标类
     * @param annotationClazz 指定注解,nullable
     * @return 返回字段集合
     */
    public static <T, U extends Annotation> List<Field> getAllFieldsWithAnontationSort(Class<? super T> clazz, Class<U> annotationClazz){
        Assert.notNull(annotationClazz, "annotaion不能为空");
        List<Field> allFields = getAllFields(clazz, annotationClazz);
        allFields.sort(Comparator.comparing(o -> getSort(o, annotationClazz)));
        return allFields;
    }

    /**
     * 判断当前类是否存在某个字段 比如GameProject 中是否存在updateTime field
     *
     * @param clazz     clazz
     * @param fieldName 字段名称
     * @return Boolean
     * @throws com.zaki.exception 没有发现fieldName时
     */
    public static <T> Field existFiled(Class<T> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new NotFountException("not found file:" + fieldName);
        }
    }

    /***
     * 给指定实例record的fieldName设置值value
     * @param record record
     * @param fieldName fieldName
     * @param value value
     * */
    public static <T, K> void setValue(T record, String fieldName, K value) {
        Class<?> clazz = record.getClass();
        try {
            Field field = existFiled(clazz, fieldName);
            field.setAccessible(true);
            field.set(record, value);
        } catch (NotFountException | IllegalAccessException e) {
            log.info(e.getMessage());
        }
    }


    private static Integer getSort(Field field, Class<? extends Annotation> annotationClazz) {
        if (!field.isAnnotationPresent(annotationClazz)) {
            throw new RuntimeException("获取排序字段错误");
        }
        Annotation annotation = field.getAnnotation(annotationClazz);
        int sort;
        try {
            Method sortMethod = annotationClazz.getMethod("sort");
            sort = (int) sortMethod.invoke(annotation);
        } catch (Exception e) {
            throw new IllegalArgumentException("获取sort方法错误");
        }
        return sort;
    }
}
