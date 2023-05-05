package br.andresgois.github.io;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
    
    
    @Bean
    CommandLineRunner init(){
        return (args) -> {
            System.out.println("Running");
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
