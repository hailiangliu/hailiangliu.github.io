package com.demo.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {
    public static void main(String[] args) {

        // 输出第一个长度为5的单词
        List<String> list = Arrays.asList("hello", "world", "hello world");

        list.stream().mapToInt(item -> {
            int len = item.length();
            System.out.println(item);
            return len;
        }).filter(len -> len == 5).findFirst().ifPresent(System.out::println);
        // 输出：hello 5，而不是hello、world、hello world  5
        // 流短路
    }
}
