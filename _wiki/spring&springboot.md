---
layout: wiki
title: Spring和springboot应用
categories: java
description: Spring和Springboot的一些实例
keywords: Spring, JAVA, Springboot
---

本文主要记录 Spring 和Springboot 的使用技巧等，使用过程中遇到的问题

[toc]

# 1、常用的类和接口实例

## 1.1springboot 中的 EnvironmentAware接口

> springboot中的bean只要实现EnvironmentAware接口，可以获取application.properties(yaml)中的配置，
>
> 可以用于初始化配置或者取出环境变量（application.yml的环境变量、命令行注入的参数），代码举例如下

```
 application.properties中内容：
 project.name=myproject
 @Configuration
 public class MyProjectc implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {
            String projectName =      environment.getProperty("project.name");
            System.out.println(projectName); // 可以得到 myproject
    }
 }  

```

## 1.2 spring 常用的几个注解

 initbean 后执行

```java
@PostConstruct
public void init() {
    System.out.println("启动即执行");
}

```

Timer

```java
// timer
@Scheduled
1.cron  --@Scheduled（cron="0/5 * * * *？"） 当时间达到设置的时间会触发事件。上面那个例子会每5秒执行一次。
2018/1/4 14:27:30
2018/1/4 14:27:35
2018/1/4 14:27:40
2018/1/4 14:27:45
2018/1/4 14:27:50
2.fixedRate --@Scheduled（fixedRate=2000）
 每两秒执行一次时间。
3.fixedDelay --@Scheduled（fixedDelay=2000）
 每次任务执行完之后的2s后继续执行
```

