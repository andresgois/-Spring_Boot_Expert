package com.github.andresgois;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean("applicationName")
    public String applicationName(){
        return "Sistema de vendas";
    }
}
