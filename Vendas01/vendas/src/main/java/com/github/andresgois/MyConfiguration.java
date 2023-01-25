package com.github.andresgois;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class MyConfiguration {

    @Bean
    public CommandLineRunner init(){
        return args -> {
          System.out.println("================= Development =================");
        };
    }
    @Bean("applicationName")
    public String applicationName(){
        return "Sistema de vendas";
    }

    @Bean("applicationCategoty")
    public String applicationCategoty(){
        return "Sistema de vendas - Categoria";
    }
}
