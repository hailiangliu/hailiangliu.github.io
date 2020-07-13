package com.lhl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="DEMOSERVER")
public interface ApiService {

    @GetMapping("/api/menu/list")
    public String listAll();
}
