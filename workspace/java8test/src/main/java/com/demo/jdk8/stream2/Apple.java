package com.demo.jdk8.stream2;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setMoney(final BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(final Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        // 1、分组
        //List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起：
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("groupBy:" + groupBy);
        //打印： groupBy:{1=[Apple{id=1, name='苹果1', money=3.25, num=10}], 2=[Apple{id=2, name='香蕉', money=2.89, num=30}], 3=[Apple{id=3, name='荔枝', money=9.99, num=40}], 6=[Apple{id=6, name='苹果2', money=1.35, num=20}]}

        //2、List转Map
        //id为key，apple对象为value，可以这么做：
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> toMap = appleList.stream().collect(Collectors.toMap(s -> s.getId(), t -> t, (k1, k2) -> k1));
        System.out.println("toMap:" + toMap);
        // 打印：toMap:{1=Apple{id=1, name='苹果1', money=3.25, num=10}, 2=Apple{id=2, name='香蕉', money=2.89, num=30}, 3=Apple{id=3, name='荔枝', money=9.99, num=40}}

        // 3、过滤Filter
        //从集合中过滤出来符合条件的元素：
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.err.println("filterList:" + filterList);
        // 输出[Apple{id=2, name='香蕉', money=2.89, num=30}]


        //4、求和
        //将集合中的数据按照某个属性求和:
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:" + totalMoney);  //totalMoney:17.48

        //5、查找流中最大 最小值
        //Collectors.maxBy 和 Collectors.minBy 来计算流中的最大或最小值。
        appleList.stream().map(Apple::getNum).collect(Collectors.maxBy((o1, o2) -> o1.compareTo(o2))).ifPresent(System.out::println);
        // 输出40，如果想输出对象呢
        appleList.stream().collect(Collectors.maxBy((o1, o2) -> o1.getNum().compareTo(o2.getNum()))).ifPresent(System.out::println);

        //6、去重
        ArrayList<Apple> unique = appleList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingLong(Apple::getId))), ArrayList::new));
        System.out.println(unique);
        // 输出：[Apple{id=1, name='苹果1', money=3.25, num=10}, Apple{id=2, name='香蕉', money=2.89, num=30}, Apple{id=3, name='荔枝', money=9.99, num=40}]

        //下表展示 Collectors 类的静态工厂方法。
    }
}