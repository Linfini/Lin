package com.zaki.reflectTest;

import java.lang.reflect.Field;
import java.util.Objects;

public class ReflectHelper {
    private Integer sort;
    private Field field;
    private String fieldValue;

    public ReflectHelper() {
    }

    public ReflectHelper(Integer sort, Field field) {
        this.sort = sort;
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReflectHelper that = (ReflectHelper) o;
        return Objects.equals(sort, that.sort) &&
                Objects.equals(field, that.field) &&
                Objects.equals(fieldValue, that.fieldValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sort, field, fieldValue);
    }
}
