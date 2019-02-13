package com.zaki.test;

import com.zaki.reflectTest.ExcelColumn;
import com.zaki.reflectTest.Student;
import com.zaki.utils.ClassUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

public class ClassUtilsTest {

    @Test
    public void getAllFields() {
        List<Field> allFields = ClassUtils.getAllFields(Student.class, ExcelColumn.class);
        assert !allFields.isEmpty();
        System.out.println(allFields);
    }
}