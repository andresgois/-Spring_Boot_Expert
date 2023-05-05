package br.andresgois.github.io.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.andresgois.github.io.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBService dbService;
    
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy; 
    
    @Bean
    public Boolean instancia() {
        if(strategy.equals("create")) {
            this.dbService.criarInstancia();
        }
        return false;
    }
}
