package com.demo.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wanghu", "zhaoliu");

        //实现两个list复合输出,必须用flatMap,如果用map，返回的是Stream<Stream>
        List<String> result = list1.stream().flatMap(item1 -> list2.stream().map(item2 -> item1 + " " + item2)).collect(Collectors.toList());
        result.forEach(System.out::println);
        //输出：
        // Hi zhangsan
        //Hi lisi
        //Hi wanghu
        //Hi zhaoliu
        //Hello zhangsan
        //Hello lisi
        //Hello wanghu
        //Hello zhaoliu
        //你好 zhangsan
        //你好 lisi
        //你好 wanghu
        //你好 zhaoliu
    }
}
