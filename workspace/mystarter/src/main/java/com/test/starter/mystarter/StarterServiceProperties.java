package com.test.starter.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example.service")
public class StarterServiceProperties {
    public String getConfig() {
        return this.config;
    }

    public void setConfig(final String config) {
        this.config = config;
    }

    private String config;

}
