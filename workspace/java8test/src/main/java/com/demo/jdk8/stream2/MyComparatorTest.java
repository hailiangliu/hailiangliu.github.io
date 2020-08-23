package com.demo.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");

        // 字典升序 [hello, nihao, welcome, world]
//        Collections.sort(list);

        //按字符串长度升序, 结果：[nihao, hello, world, welcome]
//        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());

        //按字符串长度降序, 结果：[welcome, nihao, hello, world]
//        Collections.sort(list, (item1, item2) -> item2.length() - item1.length());

        //按字符串长度倒序，使用函数引用 结果：[welcome, nihao, hello, world]
//        Collections.sort(list, Comparator.comparingInt(String::length).reversed());

        //如果不用静态引用，直接使用function，居然会报错， 编译器无法进行类型推断，必须要指定参数类型
        //Collections.sort(list, Comparator.comparingInt(str->str.length()).reversed());
//        Collections.sort(list, Comparator.comparingInt((String str)->str.length()).reversed());

        // 引出一个问题，什么情况编译器无法推断类型
        //sort 第二个参数是reversed函数转换了，编译器无法推断，如果不使用reverse的话，编译器是可以推断str类型的
//        Collections.sort(list, Comparator.comparingInt((str)->str.length()));

        //以上方法，都可以直接使用list.sort替换

        // 二层排序规则，首先对list排序，按字符串长度升序，如果长度相同，则按字典升
        // 输出： [hello, nihao, world, welcome]
//          Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

        //另一种实现  输出：[hello, nihao, world, welcome]
//        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase, Comparator.naturalOrder())));

        // 二层排序，按字符串长度降序，长度相等时 字母小写后字典降序，输出 [welcome, world, nihao, hello]
        Collections.sort(list,Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));

        System.out.println(list);
    }
}
