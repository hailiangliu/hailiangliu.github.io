package com.proxytest;

public class MyServiceImpl implements IService {
    @Override
    public String hello(String input) {
        System.out.println("actual invoke, input=" + input);
        return "resp: " + input;
    }
}
