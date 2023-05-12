package br.andresgois.github.io.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.andresgois.github.io.relacionamento.model.ManyToMany.Curso;
import br.andresgois.github.io.relacionamento.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoRepository repository;
    
    @GetMapping("/listar")
    public Iterable<Curso> list(){
        return repository.findAll();
    }
    
    @PostMapping("/cadastrar")
    public Curso cadastrar(@RequestBody Curso c){
        return repository.save(c);
    }
}
