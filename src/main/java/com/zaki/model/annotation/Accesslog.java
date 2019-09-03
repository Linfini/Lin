package com.zaki.model.annotation;

import com.zaki.model.constant.Constant;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Accesslog {
    String tag() default Constant.DEFAULT;

    String message() default Constant.DEFAULT;

}
