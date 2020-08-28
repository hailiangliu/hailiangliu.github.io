package com.designpattern.factory.factorymethod.pizzastore.pizza;

public class BJCheessePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println(" 北京的奶酪披萨 准备原材料");

    }
}
