package andresgois.github.io.criptografiasenhausuario;

import andresgois.github.io.criptografiasenhausuario.model.Usuario;
import andresgois.github.io.criptografiasenhausuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
@SpringBootApplication
public class CriptografiaSenhaUsuarioApplication {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PasswordEncoder encoder;

	@Bean
	public CommandLineRunner teste(){
		return args -> {
			Usuario u = new Usuario(null, "andre", encoder.encode("123456"));
			repository.save(u);
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
