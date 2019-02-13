package com.zaki.utils;

import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExcelHelper {
    public static List<String> errLogs = new ArrayList<>(); //错误日志
    public static Set<Integer> badColumns = new HashSet<>();//存放没有标注@Excel的列
    //存放实际错误行号,可重复 badRows为不为空时MyExcel.accept()才返回
    public static List<Integer> badRows = new ArrayList<>();
    public static List<Integer> validatorBadRows = new ArrayList<>();//存在业务校验业务行号
    public static List<String> headers; //excel 表格头
    public static Integer maxColumnNum; //excel 最大列
    public static Integer maxRowNum; //excel最大行
    public static List<Field> allFields; //被@ExcelHelper 注解表示的字段
    public static MultipartFile file = null; //存在重复性校验错误时存放file文件

    public static void clearFile() {
        file = null;
    }

    public static void clearLog() {
        errLogs = new ArrayList<>();
        badColumns = new HashSet<>();
        badRows = new ArrayList<>();
        validatorBadRows = new ArrayList<>();
    }

    public static List<String> getErrLogs() {
        return errLogs;
    }

    public static void setErrLogs(List<String> errLogs) {
        ExcelHelper.errLogs = errLogs;
    }

    public static Set<Integer> getBadColumns() {
        return badColumns;
    }

    public static void setBadColumns(Set<Integer> badColumns) {
        ExcelHelper.badColumns = badColumns;
    }

    public static List<Integer> getBadRows() {
        return badRows;
    }

    public static void setBadRows(List<Integer> badRows) {
        ExcelHelper.badRows = badRows;
    }

    public static List<Integer> getValidatorBadRows() {
        return validatorBadRows;
    }

    public static void setValidatorBadRows(List<Integer> validatorBadRows) {
        ExcelHelper.validatorBadRows = validatorBadRows;
    }

    public static List<String> getHeaders() {
        return headers;
    }

    public static void setHeaders(List<String> headers) {
        ExcelHelper.headers = headers;
    }

    public static Integer getMaxColumnNum() {
        return maxColumnNum;
    }

    public static void setMaxColumnNum(Integer maxColumnNum) {
        ExcelHelper.maxColumnNum = maxColumnNum;
    }

    public static Integer getMaxRowNum() {
        return maxRowNum;
    }

    public static void setMaxRowNum(Integer maxRowNum) {
        ExcelHelper.maxRowNum = maxRowNum;
    }

    public static List<Field> getAllFields() {
        return allFields;
    }

    public static void setAllFields(List<Field> allFields) {
        ExcelHelper.allFields = allFields;
    }

    public static MultipartFile getFile() {
        return file;
    }

    public static void setFile(MultipartFile file) {
        ExcelHelper.file = file;
    }
}
