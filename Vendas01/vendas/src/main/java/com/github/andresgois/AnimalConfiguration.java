package com.github.andresgois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {

    @Autowired
    @Gato
    private Animal animal;

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("----------- Animal");
            this.animal.fazerBarulho();
        };
    }

    @Bean(name = "cachorro")
    public Animal cachorro() {
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("Au au");
            }
        };
    }

    @Bean(name = "gato")
    public Animal gato() {
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("Miauuuu");
            }
        };
    }

}
