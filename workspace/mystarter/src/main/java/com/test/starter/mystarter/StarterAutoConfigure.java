package com.test.starter.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(StarterService.class) // 当classpath下发现该类的情况自动配置
@EnableConfigurationProperties(StarterServiceProperties.class) //
public class StarterAutoConfigure{
    @Autowired
    private StarterServiceProperties properties;


    @Bean
    @ConditionalOnMissingBean // 当spring context中不存在该bean时
    @ConditionalOnProperty(prefix = "example.service", value="enabled", havingValue = "true")
    // 当配置文件中的 example.service=true时
    StarterService starterService(){

        return new StarterService(properties.getConfig());
    }
}
