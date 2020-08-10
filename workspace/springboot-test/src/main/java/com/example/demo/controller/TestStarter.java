package com.example.demo.controller;

import com.test.starter.mystarter.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestStarter {

    @Autowired
    StarterService starterService;

    @RequestMapping("test")
    public Map<String, Object> testMyStarter(String testStr) {
        String[] split = starterService.split(testStr);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("testStr", split);
        return objectObjectHashMap;

    }
}
