package br.andresgois.github.io.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.andresgois.github.io.relacionamento.model.ManyToMany.Aluno;
import br.andresgois.github.io.relacionamento.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repository;
    
    @GetMapping("/listar")
    public Iterable<Aluno> list(){
        return repository.findAll();
    }
    
    @PostMapping("/cadastrar")
    public Aluno cadastrar(@RequestBody Aluno c){
        return repository.save(c);
    }
}
