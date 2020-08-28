package com.designpattern.factory.simplefactory.pizzastore;

//相当于一个客户端，发出订购

public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();
        //使用简单工厂

        new OrderPizza(new SimpleFactory());
        System.out.println("结束");
    }
}
