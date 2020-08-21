package com.demo.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");
        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);

        // 什么都不输出，没有终止操作时，中间操作不会执行
        list.stream().map(item->{
            String result = item.substring(0,1).toUpperCase()+item.substring(1);
            System.out.println("test");
            return result;
        });

    }
}
