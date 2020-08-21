package com.demo.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest8 {
    public static void main(String[] args) {
        // 0 1 0 1 0 1 0 1的stream, 死循环， distinct会一直等待iterate结束
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        //调换函数顺序，先限制数量，后去重，则正常
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);

    }
}
