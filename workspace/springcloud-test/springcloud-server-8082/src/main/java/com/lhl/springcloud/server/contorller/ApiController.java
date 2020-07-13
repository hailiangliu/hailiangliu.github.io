package com.lhl.springcloud.server.contorller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ApiController {

    @Value("${server.port}")
    public String port;

    @RequestMapping("api/menu/list")
    public String listMenu(){

        log.info("----api接收到请求----,port=" + port);
        HashMap<String, String> result = Maps.newHashMap();

        result.put("menu1","value1");
        result.put("port",port);

        return result.toString();
    }
}
