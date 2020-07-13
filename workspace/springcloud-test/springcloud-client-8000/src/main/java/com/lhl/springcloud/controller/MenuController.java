package com.lhl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class MenuController {


    // String url = "http://localhost:8081/api/menu/list";
    String url = "http://DEMOSERVER"; // 使用eureka后 这里替换为 server注册的appname

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getAllMenu")
    public String getAllMenu() {
        log.info("-----客户端接收浏览器请求，请求api");
        return restTemplate.getForObject(url + "/api/menu/list", String.class, new HashMap<>());
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/client")
    public Object discovery() {
        List<String> services = client.getServices();
        services.forEach(str -> log.info("services: :" + str));


        List<ServiceInstance> instances = client.getInstances("DEMO-CLIENT");

        instances.forEach(instance -> {
            log.info(String.format("%s,%d,%s,%s,%s,%s", instance.getHost(), instance.getPort() + "", instance.getUri().toString(), instance.getServiceId(), instance.getScheme()));
        });

        return client;
    }
}
