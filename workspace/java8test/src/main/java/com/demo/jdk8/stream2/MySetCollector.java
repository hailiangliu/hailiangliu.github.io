package com.demo.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * Collector<> 第一个是接收的参数类型，第二个是过程中的容器，第三个是结果返回类型
 *
 * @param <T>
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
//        return ()->new HashSet<T>();
        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!!!");
//        return (ts, t) -> ts.add(t);
        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke!");
        return (ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoke!");
//        return (set) -> {
//            return set;
//        };
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");

        Set<String> set = list.stream().collect(new MySetCollector<>());
        System.out.println(set);
        // 输出
        // supplier invoked!
        // accumulator invoked!!!
        // combiner invoke!
        // characteristics invoked!
        // characteristics invoked!
        // [world, hello, welcome]

    }
}
