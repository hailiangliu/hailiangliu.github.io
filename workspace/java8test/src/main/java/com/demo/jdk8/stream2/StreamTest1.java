package com.demo.jdk8.stream2;

import com.demo.jdk8.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wanghu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // 计算 stream内数量
        Long count1 = students.stream().collect(Collectors.counting());
        long count = students.stream().count();

        // 找出分数最低的学生 (最高）
        students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(student -> System.out.println(student.getName())); // 输出zhangsan
        // 求平均分 (求和)
        System.out.println(students.stream().collect(Collectors.averagingDouble(Student::getScore))); // 输出90.0

        //拼接
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining()));// zhangsanlisiwanghuzhaoliu
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", "))); //zhangsan, lisi, wanghu, zhaoliu
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(",", "<begin>", "<end>")));//<begin>zhangsan,lisi,wanghu,zhaoliu<end>

        //分组
        Map<Integer, Map<String, List<Student>>> groupResult = students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));

        //分区
        Map<Boolean, Map<Boolean, List<Student>>> partitionResult = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 80, Collectors.partitioningBy(student -> student.getScore() > 90)));
        //分区 value为计数
        Map<Boolean, Long> countingResult = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 80, Collectors.counting()));
        //
        Map<String, Student> result = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
    }
}
