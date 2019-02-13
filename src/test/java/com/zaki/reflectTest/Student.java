package com.zaki.reflectTest;

public class Student extends Person{
    @ExcelColumn(value = "分数",sort = 3)
    private Integer grade;
    @ExcelColumn(value = "学校",sort = 2)
    private String school;


    public Student() {
    }

    public String getSchool() {
        return school;
    }

    public Student(Integer grade, String school) {
        this.grade = grade;
        this.school = school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
