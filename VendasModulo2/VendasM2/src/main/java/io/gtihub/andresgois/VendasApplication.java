package io.gtihub.andresgois;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.entity.ClienteTeste;
import io.gtihub.andresgois.domain.repository.ClienteRepository;
import io.gtihub.andresgois.domain.repository.ClientesRepository;
import io.gtihub.andresgois.domain.repository.ICientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    //@Bean
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

    //@Bean
    public CommandLineRunner iniciarComEntityManaged(@Autowired ClienteRepository repository){
        return args -> {// ele gera um id autormático
            Cliente cliente = new Cliente("Andre Gois");
            repository.salvar(cliente);
            System.out.println(cliente);
        };
    }

    @Bean
    public CommandLineRunner initJpaRepository(@Autowired ICientesRepository repository){
        return args -> {// ele gera um id autormático
            Cliente cliente = new Cliente("Andre Gois");
            repository.save(cliente);
            System.out.println(cliente);
            repository.save(new Cliente("Priscila"));

            System.out.println("=============Listar todos ==============");
            List<Cliente> cli = repository.findAll();
            cli.forEach(System.out::println);
            System.out.println("=============Existe ==============");
            boolean existe = repository.existsByNome("Priscila");
            System.out.println("Existe alguém com nome de Priscila no banco? "+existe);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
