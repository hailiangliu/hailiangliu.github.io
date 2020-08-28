package com.designpattern.factory.absfacctory.pizzstore.order;

import com.designpattern.factory.absfactory.pizzastore.pizza.BJCheessePizza;
import com.designpattern.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.designpattern.factory.absfactory.pizzastore.pizza.Pizza;

//工厂子类
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equalsIgnoreCase("cheese")) {
            pizza = new BJCheessePizza();
        } else if (orderType.equalsIgnoreCase("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
