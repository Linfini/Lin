package com.zaki.reflectTest;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Bean
public @interface ExcelColumn {
    String value();
    int sort() default 0;
}
