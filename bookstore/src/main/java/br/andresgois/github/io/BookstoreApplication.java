package br.andresgois.github.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.andresgois.github.io.domain.Categoria;
import br.andresgois.github.io.domain.Livro;
import br.andresgois.github.io.repository.CategoriaRepository;
import br.andresgois.github.io.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
    
    
    @Bean
    CommandLineRunner init(){
        return (args) -> {
            System.out.println("Running");
            Categoria cat1 = new Categoria(null, "Informatica", "Livro de T.I");
            Livro liv1 = new Livro(null, "Clean Code", "Robert c. martin", "Lorem ipsum", cat1);
            
            categoriaRepository.save(cat1);
            livroRepository.save(liv1);
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
