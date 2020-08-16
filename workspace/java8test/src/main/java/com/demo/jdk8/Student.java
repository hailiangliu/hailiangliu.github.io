package com.demo.jdk8;

public class Student {
    private String name = "zhangsan";
    private int age = 20;

    Student() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
