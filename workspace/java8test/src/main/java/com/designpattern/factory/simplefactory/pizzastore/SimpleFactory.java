package com.designpattern.factory.simplefactory.pizzastore;

import com.designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

public class SimpleFactory {
    // 根据orderType生成pizza对象
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equalsIgnoreCase("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (orderType.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        } else {

        }
        return pizza;
    }
}
