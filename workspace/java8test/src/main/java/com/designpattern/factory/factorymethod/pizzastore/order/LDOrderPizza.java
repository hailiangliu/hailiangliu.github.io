package com.designpattern.factory.factorymethod.pizzastore.order;

import com.designpattern.factory.factorymethod.pizzastore.pizza.LDCheessePizza;
import com.designpattern.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import com.designpattern.factory.factorymethod.pizzastore.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equalsIgnoreCase("cheese")) {
            pizza = new LDCheessePizza();
        } else if (orderType.equalsIgnoreCase("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
