package br.andresgois.github.io.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.andresgois.github.io.relacionamento.model.OneToMany.Postagem;
import br.andresgois.github.io.relacionamento.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
    
    @Autowired
    private PostagemRepository repository;
    
    @GetMapping("/listar")
    public Iterable<Postagem> list(){
        return repository.findAll();
    }
    
    @PostMapping("/cadastrar")
    public Postagem cadastrar(@RequestBody Postagem c){
        return repository.save(c);
    }
}
