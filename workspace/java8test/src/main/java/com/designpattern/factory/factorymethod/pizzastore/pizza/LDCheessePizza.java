package com.designpattern.factory.factorymethod.pizzastore.pizza;

public class LDCheessePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        System.out.println(" 伦敦的奶酪披萨 准备原材料");

    }
}
