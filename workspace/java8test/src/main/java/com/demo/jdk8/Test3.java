package com.demo.jdk8;

import java.util.*;
import java.util.function.Function;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        //转换为大写
        list.forEach(item -> System.out.println(item.toUpperCase()));

        List<String> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item.toLowerCase()));

        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        // 等价于 方法引用
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        //分步 定义一个函数
        Function<String, String> function = String::toUpperCase;


        // 函数时编程得简化举例
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        //原始匿名内部类方式
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        // lambda 第一步
        Collections.sort(names,(String o1, String o2)->{
            return o2.compareTo(o1);
        });
        // 简写，省略类型, 一行方法体省略括号，和return
        Collections.sort(names,(o1,o2)->o2.compareTo(o1));


    }
}
