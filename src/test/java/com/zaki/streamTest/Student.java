package com.zaki.streamTest;

public class Student {
    private String name;
    private String id;
    private Integer sumAge;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSumAge() {
        return sumAge;
    }

    public void setSumAge(Integer sumAge) {
        this.sumAge = sumAge;
    }

    public Student() {
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
