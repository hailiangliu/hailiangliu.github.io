package com.demo.jdk8;

public class Person {
    private String username;
    private int age;

    public Person(final String username, final int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
