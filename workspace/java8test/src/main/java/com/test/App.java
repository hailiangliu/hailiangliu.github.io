package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        char c = '"';
        String s = "中2";


        System.out.println( s.getBytes().length); // 4  汉字3
        System.out.println( String.valueOf(c).getBytes().length);
        System.out.println( 1 << 30);
        System.out.println( Math.pow(2,30));


        HashMap hashMap = new HashMap();

        Executors.newCachedThreadPool();

        ReentrantLock lock = new ReentrantLock(true);

        lock.tryLock();
        lock.lock();
    }
}
