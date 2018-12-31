package com.demoJDBC.demoJDBC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class AppConfig {


    @Bean
    public Logger getLogger(){

        return Logger.getLogger(getClass().getName());
    }
}
