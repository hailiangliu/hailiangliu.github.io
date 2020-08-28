package com.designpattern.factory.simplefactory.pizzastore;

import com.designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    //    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType;// 订购pizza的类型
//        do {
//            orderType = this.getType();
//
//            if (orderType.equalsIgnoreCase("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("希腊披萨");
//            } else if (orderType.equalsIgnoreCase("cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName("奶酪披萨");
//            } else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//
//        } while (true);
//    }
    // 定义一个简单工厂对象
    SimpleFactory simpleFactory;

    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType = "";// 用户输入的
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = simpleFactory.createPizza(orderType);

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
