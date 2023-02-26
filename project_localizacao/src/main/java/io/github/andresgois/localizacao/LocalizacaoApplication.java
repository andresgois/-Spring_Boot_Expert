package io.github.andresgois.localizacao;

import io.github.andresgois.localizacao.domain.entity.Cidade;
import io.github.andresgois.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Iniciou ----");
		salvar();
		listar();
	}

	@Transactional
	void salvar(){
		Cidade cidade = new Cidade(1L, "São Paulo", 12369789632L);
		cidadeRepository.save(cidade);
	}

	void listar(){
		cidadeRepository.findAll().forEach(System.out::println);
	}
}
