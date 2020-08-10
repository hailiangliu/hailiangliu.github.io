package com.test;

/**
 * 面试题：
 * 假设只分配50m堆内存，new 一个 45m的对象，会怎样
 * <p>
 * -Xms60m -Xmx60m
 *
 * 新生代 老年代 1：2   from s0 s1 8:1:1
 *
 * 60m算  老年代40m，新生代是20m , from 是16m，s0=s1=2m
 * 一次估算一次new 40m 会oom， 实测 40 OOM、39 ok
 *
 *  指定 –XX:NewRatio=4  老年代是新生代4倍
 *  60m算  老年代48m，新生代是12m , from 是10m，s0=s1=1m
 *  估算 一次new 48m 会溢出，实际测 47ok , 48 OOM
 */
public class TestBigObject {
    public static void main(String[] args) {
        //获取当前堆的大小 byte 单位
        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("堆总计:" + heapSize/(1024*1024));

        //获取堆的最大大小byte单位
        //超过将抛出 OutOfMemoryException
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        System.out.println("最大" + heapMaxSize/(1024*1024));

        //获取当前空闲的内存容量byte单位
        long heapFreeSize = Runtime.getRuntime().freeMemory();
        System.out.println("空闲" + heapFreeSize/(1024*1024));

        int _1mb = 1 * 1024 * 1024;
        byte[] bigObject = new byte[_1mb * 48];
    }
}
