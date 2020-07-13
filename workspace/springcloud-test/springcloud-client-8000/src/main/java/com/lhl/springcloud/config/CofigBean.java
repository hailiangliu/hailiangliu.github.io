package com.lhl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CofigBean {

    @Bean
    @LoadBalanced // 使用负载均衡 ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
