package com.test.starter.mystarter;


public class StarterService {
    private String config;

    public StarterService(final String config) {
        this.config = config;
    }

    public String[] split(String separatorChar){
        return separatorChar.split(config);
    }
}
