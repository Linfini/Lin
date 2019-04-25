package com.zaki.model.annotation;

public @interface ExcelColumn {
    String value();

    int sort() default 100;

    boolean notNull() default false;
}
