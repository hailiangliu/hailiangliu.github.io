package com.designpattern.factory.absfacctory.pizzstore.order;

import com.designpattern.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory absFactory;

    public void setFactory(AbsFactory factory) {
        Pizza pizza = null;
        String orderType = "";
        this.absFactory = factory;

        do {
            orderType = getType();
            pizza = factory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }

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
