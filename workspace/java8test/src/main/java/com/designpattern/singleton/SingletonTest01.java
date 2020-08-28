package com.designpattern.singleton;

public class SingletonTest01 {
    public static void main(String[] args) {

    }
}

// 饿汉式 (静态变量）
class Singleton {

    // 1、构造器私有化，防止外部直接new
    private Singleton() {
    }

    // 2、本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3、 提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}

//饿汉式 (静态代码块）
class Singleton02 {
    // 1、构造器私有化，防止外部直接new
    private Singleton02() {
    }

    // 2、本类内部创建对象实例
    private static Singleton02 instance;

    static { // 在静态代码快中初始化
        instance = new Singleton02();
    }

    //3、 提供一个共有的静态方法，返回实例对象
    public static Singleton02 getInstance() {
        return instance;
    }
}

// 懒汉式（线程不安全）
class Singleton03 {
    private static Singleton03 instance;

    private Singleton03() {
    }

    //提供一个静态公有方法，当调用改方法时，才去创建instance
    public static Singleton03 getInstance() {
        if (instance == null)
            instance = new Singleton03();
        return instance;
    }
}

// 懒汉式（线程安全）
class Singleton04 {
    private static Singleton04 instance;

    private Singleton04() {
    }

    //提供一个静态公有方法，当调用改方法时，才去创建instance
    public static synchronized Singleton04 getInstance() {
        if (instance == null)
            instance = new Singleton04();
        return instance;
    }
}

// 懒汉式（双重检查）
class Singleton05 {
    private static volatile Singleton05 instance;

    private Singleton05() {
    }

    //提供一个静态公有方法，当调用改方法时，才去创建instance
    public static Singleton05 getInstance() {
        if (instance == null) {
            synchronized (Singleton05.class) {
                if (instance == null) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
