package br.andresgois.github.io.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.andresgois.github.io.relacionamento.model.OneToMany.Comentario;
import br.andresgois.github.io.relacionamento.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    
    @Autowired
    private ComentarioRepository repository;
    
    @GetMapping("/listar")
    public Iterable<Comentario> list(){
        return repository.findAll();
    }
    
    @PostMapping("/cadastrar")
    public Comentario cadastrar(@RequestBody Comentario c){
        return repository.save(c);
    }
}
