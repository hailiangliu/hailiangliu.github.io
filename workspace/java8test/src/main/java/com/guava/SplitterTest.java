package com.guava;

import com.google.common.base.Splitter;

import java.util.Map;
import java.util.Objects;

public class SplitterTest {
    public static void main(String[] args) {
        Splitter.on(",").omitEmptyStrings().splitToList("123,456,789,,23").forEach(System.out::println);
        //输出：
        //123
        //456
        //789
        //23

        Splitter.on(",").limit(2).splitToList("123,456,789,,23").forEach(System.out::println);
        //输出：
        // 123
        //456,789,,23

        Splitter.on(",").trimResults().splitToList("12 3, 456 ,789,,23").forEach(System.out::println);
        //输出
        //12 3
        //456
        //789
        //
        //23

        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("-").split("1-2,3-5");
        System.out.println(map);
        // 输出：
        // {1=2, 3=5}

    }
}
