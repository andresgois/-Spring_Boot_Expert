package io.gtihub.andresgois;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository repository){
        return args -> {
          Cliente cliente = new Cliente();
          cliente.setNome("Andre");
          repository.salvaCliente(cliente);

          repository.salvaCliente(new Cliente("Douglas"));

            List<Cliente> todos = repository.obterTodos();
            todos.forEach(System.out::println);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
