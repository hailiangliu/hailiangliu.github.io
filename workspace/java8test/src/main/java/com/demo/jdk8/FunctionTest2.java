package com.demo.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();


        // 输出12， 先计算function2即 2^2, 在执行function1即 4*3  = 12
        System.out.println(functionTest2.compute(2, value -> value * 3, value -> value * value));

        // 输出36， 先计算function1即2*3=6， 再执行function1即6^6 =36
        System.out.println(functionTest2.compute2(2, value -> value * 3, value -> value * value));

        System.out.println(functionTest2.compute3(1, 2, (v1, v2) -> v1 + v2)); // 输出 3
        System.out.println(functionTest2.compute3(1, 2, (v1, v2) -> v1 - v2)); // 输出 -1
        System.out.println(functionTest2.compute3(1, 2, (v1, v2) -> v1 * v2)); // 输出 2
        System.out.println(functionTest2.compute3(1, 2, (v1, v2) -> v1 / v2)); // 输出 0

    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> functon2) {
        return function1.compose(functon2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> funciton1, Function<Integer, Integer> function2) {
        return funciton1.andThen(function2).apply(a);
    }

    // 使用BiFunction 传递四则运算
    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> function) {
        return function.apply(a, b);
    }
}
