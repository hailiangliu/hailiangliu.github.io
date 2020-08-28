package com.designpattern.factory.factorymethod.pizzastore.order;

import com.designpattern.factory.factorymethod.pizzastore.pizza.BJCheessePizza;
import com.designpattern.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.designpattern.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equalsIgnoreCase("cheese")) {
            pizza = new BJCheessePizza();
        } else if (orderType.equalsIgnoreCase("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
