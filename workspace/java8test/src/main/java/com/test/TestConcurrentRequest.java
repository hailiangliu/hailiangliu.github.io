package com.test;

import cn.hutool.core.date.DateUtil;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class TestConcurrentRequest {
    public static void main(String[] args) throws InterruptedException, IOException {

        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {

                System.out.println(DateUtil.formatTime(new Date()) + ": 线程[" + finalI + "] 开始");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(DateUtil.formatTime(new Date()) + ": 线程[" + finalI + "] 执行");

            }).start();
        }
        Thread thread = Thread.currentThread();
        System.out.println("----- 开始等待 ------");
        thread.sleep(5000);

        latch.countDown();

        int read = System.in.read();
        System.out.println("read = " + read);

    }
}
