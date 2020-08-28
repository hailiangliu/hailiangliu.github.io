package com.designpattern.factory.absfacctory.pizzstore.order;

import com.designpattern.factory.absfactory.pizzastore.pizza.LDCheessePizza;
import com.designpattern.factory.absfactory.pizzastore.pizza.LDPepperPizza;
import com.designpattern.factory.absfactory.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equalsIgnoreCase("cheese")) {
            pizza = new LDCheessePizza();
        } else if (orderType.equalsIgnoreCase("pepper")) {
            pizza = new LDPepperPizza();
        }

        return pizza;
    }
}
