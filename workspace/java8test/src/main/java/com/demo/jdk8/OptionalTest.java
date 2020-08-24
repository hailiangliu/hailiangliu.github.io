package com.demo.jdk8;

import cn.hutool.core.lang.Pair;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("hello"); // 构造Optional对象， of函数内部会判断传入如果为空抛异常
        // Optional<String> optional2 = Optional.ofNullable("hello"); // 构造Optional对象， 可接受null

        if(optional1.isPresent()){//如果存在则打印
            System.out.println(optional1.get());  // 如果容器内为null，则抛异常，因此要做isPresenet判断
        }
        // 上面这种方式不建议，因为和 ==null的判断方式无本质区别

        // 官方建议使用函数式编程来实现
        optional1.ifPresent((str)-> System.out.println(str)); //如果不为空直接执行，为空的话不执行此逻辑的

        // Optional内为空的话，填充一个(输入的参数）
        System.out.println(optional1.orElse("world"));
        // Optional内为空的话，填充一个(使用传入的Suppler生成
        System.out.println(optional1.orElseGet(()->"niihao"));


        // 测试
        Map<String, Map> map = null;
        Optional<Map> result = Optional.ofNullable(map);
        Map map1 = result.map(Function.identity()).orElseGet(HashMap::new); //如果有值则返回自己，无则新生成一个hashmap

    }
}
