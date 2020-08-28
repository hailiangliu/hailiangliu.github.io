package com.designpattern.factory.absfactory.pizzastore.pizza;

public abstract class Pizza {

    protected String name;

    //准备原材料
    public abstract void prepare();

    // 烘烤
    public void bake() {
        System.out.println(name + " baking;");
    }

    //切割
    public void cut() {
        System.out.println(name + " cutting;");
    }

    //装箱
    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }

}