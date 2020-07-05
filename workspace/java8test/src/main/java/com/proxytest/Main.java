package com.proxytest;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MyHandler handler = new MyHandler(new MyServiceImpl());

        Object proxyService = Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{IService.class}, handler);

        IService service = (IService) proxyService;

        System.out.println("resp=" +  service.hello("nihao"));

    }
}
