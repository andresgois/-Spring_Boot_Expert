package br.andresgois.github.io.relacionamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.andresgois.github.io.relacionamento.model.ManyToMany.Aluno;
import br.andresgois.github.io.relacionamento.model.ManyToMany.Curso;
import br.andresgois.github.io.relacionamento.repository.AlunoRepository;
import br.andresgois.github.io.relacionamento.repository.CursoRepository;

@SpringBootApplication
public class RelacionamentoApplication {

    @Autowired
    private CursoRepository repository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Bean
    CommandLineRunner init() {
        Aluno a1 = new Aluno();
        
        a1.setAluno("Andre");
        alunoRepository.save(a1);
        
        Curso c1 = new Curso();
        c1.setCurso("Java - Spring boot");
        
        Curso c2 = new Curso();
        c2.setCurso("Python - Flask");
        
        Curso c3 = new Curso();
        c3.setCurso("PHP - Laravel");
                
        repository.saveAll(Arrays.asList(c1,c2,c3));
        
        a1.getCursos().addAll(Arrays.asList(c1, c3));
        alunoRepository.save(a1);
        
        return args -> {
            //repository.saveAll();
            System.out.println("Running");
        };
    }
    
	public static void main(String[] args) {
		SpringApplication.run(RelacionamentoApplication.class, args);
	}

}
