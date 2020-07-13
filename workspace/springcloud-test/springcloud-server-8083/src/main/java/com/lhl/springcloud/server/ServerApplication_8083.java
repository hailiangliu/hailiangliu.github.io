package com.lhl.springcloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerApplication_8083 {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication_8083.class, args);
    }

}
