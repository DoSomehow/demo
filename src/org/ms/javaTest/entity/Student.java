package org.ms.javaTest.entity;

public class Student extends Human {

    private String schoolName;


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                "sex='" + super.getSex() + '\'' +
                "age='" + super.getAge() + '\'' +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
