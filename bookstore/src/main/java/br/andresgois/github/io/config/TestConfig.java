package br.andresgois.github.io.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.andresgois.github.io.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private DBService dbService;
    
    @Bean
    public void instancia() {
        this.dbService.criarInstancia();
    }
}
