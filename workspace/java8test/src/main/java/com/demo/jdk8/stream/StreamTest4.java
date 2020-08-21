package com.demo.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");

        Stream<String> stream = list.stream(); // list 转 stream

        // stream 转 数组
        String[] result = stream.toArray(length -> new String[length]);
        String[] result1 = stream.toArray(String[]::new);

        // stream 转list
        List<String> toList = stream.collect(Collectors.toList()); // Collector工具方法
        ArrayList<String> toList2 = stream.collect(() -> new ArrayList<String>(),
                (theList, item) -> theList.add(item), (list1, list2) -> list1.addAll(list2));
        // 改成静态引用
        LinkedList<String> toList3 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);


        // stream 转 set
        Set<String> set1 = stream.collect(Collectors.toSet());
        Set<String> set2 = stream.collect(Collectors.toCollection(() -> new TreeSet<String>()));

        // stream 合并拼接一个字符串
        String str = stream.collect(Collectors.joining("-"));

        // 全部转大写
        stream.map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);


        // flatMap， 扁平
        Stream<List<Integer>> flatStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        // 打散后 平方
        flatStream.flatMap(theList -> theList.stream()).map(item->item*item).forEach(System.out::println);

    }
}
