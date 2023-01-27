package io.gtihub.andresgois;

import io.gtihub.andresgois.domain.entity.ClienteTeste;
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
          ClienteTeste clienteTeste = new ClienteTeste();
          clienteTeste.setId(1);
          clienteTeste.setNome("Andre");
          repository.salvaCliente(clienteTeste);

          repository.salvaCliente(new ClienteTeste(2,"Douglas"));

            List<ClienteTeste> todos = repository.obterTodos();
            todos.forEach(System.out::println);

            System.out.println("=============ATUALIZAR=================");
            todos.forEach( c -> {
                c.setNome(c.getNome() + " Atualizado");
                repository.atualizar(c);
            });

            todos = repository.obterTodos();
            todos.forEach(System.out::println);

            System.out.println("=============POR NOME=================");
            repository.buscaPorNome("And").forEach(System.out::println);

            System.out.println("=============DELETAR=================");
            /*repository.obterTodos().forEach( c -> {
                repository.deletar(c);
            });

            todos = repository.obterTodos();
            if(todos.isEmpty()){
                System.out.println("Nenhum clienteTeste encontrado");
            } else {
                todos.forEach(System.out::println);
            }*/
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
