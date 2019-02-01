package com.zaki.jsontest;

public class PiProductInputExcelDto {
    private String code;
    private Double num;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PiProductInputExcelDto{" +
                "code='" + code + '\'' +
                ", num=" + num +
                '}';
    }
}
