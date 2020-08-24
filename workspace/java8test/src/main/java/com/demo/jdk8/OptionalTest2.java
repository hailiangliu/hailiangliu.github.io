package com.demo.jdk8;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {

        Home homeWithoutTV= new Home();
        Optional<Home> optionalHome = Optional.ofNullable(homeWithoutTV);
        String color = optionalHome.map(home -> home.getTv()).map(tv -> tv.getColor()).orElseGet(() -> "no");
        System.out.println("homeWithoutTV color = " + color);


        Optional<Home> nullObject = Optional.ofNullable(null);
        String color1 = optionalHome.map(home -> home.getTv()).map(tv -> tv.getColor()).orElseGet(() -> "no");
        System.out.println("nullObject color = " + color1);

        Home homeWithTV = new Home();
        TV tv = new TV(new TVScreen(100,50),"red");
        homeWithTV.setTv(tv);
        Optional<Home> homeOptional = Optional.ofNullable(homeWithTV);
        String color2 = homeOptional.map(home -> home.getTv()).map(t -> t.getColor()).orElseGet(() -> "no");
        System.out.println("homeOptional color = " + color2);

    }
}
//定义一个家对象，家中可有电视，电视有屏幕和颜色，屏幕有尺寸
class Home{
    private TV tv;

    public TV getTv() {
        return this.tv;
    }

    public void setTv(final TV tv) {
        this.tv = tv;
    }
}
class TV{
    private TVScreen tvScreen;
    private String color;

    public TV() {
    }

    public TV(final TVScreen tvScreen, final String color) {
        this.tvScreen = tvScreen;
        this.color = color;
    }

    public TVScreen getTvScreen() {
        return this.tvScreen;
    }

    public void setTvScreen(final TVScreen tvScreen) {
        this.tvScreen = tvScreen;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(final String color) {
        this.color = color;
    }
}
class TVScreen{
    private int hight;
    private int width;

    public TVScreen(final int hight, final int width) {
        this.hight = hight;
        this.width = width;
    }

    public int getHight() {
        return this.hight;
    }

    public void setHight(final int hight) {
        this.hight = hight;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }
}
