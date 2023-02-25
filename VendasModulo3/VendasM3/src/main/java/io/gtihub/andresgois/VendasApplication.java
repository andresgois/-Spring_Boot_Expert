package io.gtihub.andresgois;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VendasApplication extends SpringBootServletInitializer {

    //@Bean
    public CommandLineRunner init(@Autowired IClientesRepository c){
        return args -> {
            Cliente cliente = new Cliente(null, "André Gois");
            c.save(cliente);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
