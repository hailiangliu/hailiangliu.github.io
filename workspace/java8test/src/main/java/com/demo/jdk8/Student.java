package com.demo.jdk8;

public class Student {
    private String name = "zhangsan";
    private int age = 20;
    private int score = 100;

    Student() {

    }

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public Student(String name, int score, int age) {
        this.score = score;
        this.name = name;
        this.age = age;
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

    public int getScore() {
        return this.score;
    }

    public void setScore(final int score) {
        this.score = score;
    }
}
