package andresgois.github.io.criptografiasenhausuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class CriptografiaSenhaUsuarioApplication {

	@Bean
	public CommandLineRunner teste(){
		return args -> {
			System.out.println("Running");
		};
	}

	@Bean
	public PasswordEncoder getPasswordEnconder(){
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		return enconder;
	}

	public static void main(String[] args) {
		SpringApplication.run(CriptografiaSenhaUsuarioApplication.class, args);
	}

}
