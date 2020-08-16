package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyInterface {
    void test();

    String toString();
}

public class Test1 {
    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.myTest(() -> {
            System.out.println("my implements");
        });

        System.out.println("等价于以下");
        MyInterface myInterface = () -> {
            System.out.println("hello");
        };
        test1.myTest(myInterface);
        System.out.println(myInterface.getClass()); // class com.demo.jdk8.Test1$$Lambda$2/1747585824
        System.out.println(myInterface.getClass().getSuperclass());//class java.lang.Object
        System.out.println(myInterface.getClass().getInterfaces()[0]); //interface com.demo.jdk8.MyInterface


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        list.forEach((Integer i) -> {
            System.out.println( i*2);
        });
        // 可以简写，因为list类型固定，java编译时可以推断类型
        list.forEach( i ->{
            System.out.println(i*2);
        });
        // 继续简写, 只有一行可以省略括号
        list.forEach(i -> System.out.println(i*2));
        // 继续简写, 只有一个参数，通过静态引用简写
        list.forEach(System.out::println);
    }
}
