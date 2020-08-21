package com.demo.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) throws Exception {
        // 生成流的用法
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        System.out.println(stream.findFirst().get()); // findFirst返回optional, 直接get可能出npe，因此不可
        stream.findFirst().ifPresent(System.out::println);// 建议写法
        //   stream.findFirst().orElseThrow(Exception::new).;

        // 按规则，生成10个
        Stream<Integer> streamInt = Stream.iterate(1, item -> item + 2).limit(10);
        // 找出流中大于2的元素，然后将每个元素诚意2，然后忽略掉流中的前两个元素，然后再取出流中的前两个元素，最后求出流中元素的综合
        System.out.println(streamInt.filter(i->i>2).mapToInt(i->i*2).skip(2).limit(2).sum()); // 32
        // 如果需要同时求 sum，min max, 使用多个stream不合理，jdk内设置了
        IntSummaryStatistics intSummaryStatistics = streamInt.filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).summaryStatistics();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getMin();
        intSummaryStatistics.getAverage();


    }
}
