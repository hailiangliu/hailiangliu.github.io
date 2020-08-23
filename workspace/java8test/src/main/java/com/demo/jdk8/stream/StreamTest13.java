package com.demo.jdk8.stream;

import com.demo.jdk8.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wanghu", 90, 30);
        Student student4 = new Student("zhaoliu", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        //求 按名字分组 结果返回 Map<Stirng,List<Student>
        Map<String, List<Student>> result = students.stream().collect(Collectors.groupingBy(Student::getName));

        //求 按得分分组，
        Map<Integer, List<Student>> result2 = students.stream().collect(Collectors.groupingBy(Student::getScore));

        //求 按姓名分组，value为得分相同的数量
        Map<String, Long> result3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        //求 按姓名分组，value为得分的平均值
        Map<String, Double> result4 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble((val)->val.getScore()))); // 最后可静态应用

        //求 按score分区，超过90分的为通过，反之不通过，  结果返回Map<Boolean, List<Strudent>
        Map<Boolean, List<Student>> result5 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

    }
}
