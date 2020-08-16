package com.demo.jdk8;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world!";

        Supplier<Student> studentSupplier = ()->new Student();
        studentSupplier.get().getAge(); // 获取一个

        Supplier<Student> studentSupplier1 = Student::new; // 简化写法，要求Studen类必须有一个无参构造方法（也可以有其他构造方法）


    }
}
