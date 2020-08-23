package com.demo.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hellow world hello", "hello welcome");
        // 找出集合中所有单词，并去重
        list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println);
        // 输出结果如下，显然不对，map方法错误，只对每个字符串进行spilt并返回的是个数组，因此输出的是个数组
        //[Ljava.lang.String;@5fd0d5ae
        //[Ljava.lang.String;@2d98a335
        //[Ljava.lang.String;@16b98e56
        //[Ljava.lang.String;@7ef20235

        list.stream().flatMap(str -> Arrays.stream(str.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        //输出结果：
        //hello
        //welcome
        //world
        //hellow
    }
}
