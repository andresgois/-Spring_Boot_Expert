package andresgois.github.io.criptografiasenhausuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CriptografiaSenhaUsuarioApplication {

	@Bean
	public CommandLineRunner teste(){
		return args -> {
			System.out.println("Running");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CriptografiaSenhaUsuarioApplication.class, args);
	}

}
