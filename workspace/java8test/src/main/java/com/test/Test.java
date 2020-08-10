package com.test;

public class Test {
    public volatile static int num = 0;

    public static void main(String[] args) {

        final Object lock  = new Object();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (num % 2 == 0) {
                            System.out.println("偶数：" + num);
                            try {
                                num++;
                                lock.notifyAll();
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (num % 2 != 0) {
                            System.out.println("奇数:" + num);
                            try {
                                num++;
                                lock.notifyAll();
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).

                start();

    }

}