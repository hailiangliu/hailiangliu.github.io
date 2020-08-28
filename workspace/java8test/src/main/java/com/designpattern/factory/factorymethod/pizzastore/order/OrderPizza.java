package com.designpattern.factory.factorymethod.pizzastore.order;

import com.designpattern.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {


    Pizza pizza = null;


    public void OrderPizza() {
        String orderType = "";// 用户输入的
        do {
            orderType = getType();
            pizza = createPizza(orderType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购pizza失败");
                break;
            }
        } while (true);
    }

    abstract Pizza createPizza(String orderType);

    // 写一个方法，可以获取客户订购的披萨种类
    private String getType() {
        try {
            final BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            final String str = strin.readLine();
            return str;
        } catch (final IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
