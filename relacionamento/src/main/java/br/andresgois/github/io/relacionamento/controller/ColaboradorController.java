package br.andresgois.github.io.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.andresgois.github.io.relacionamento.model.OneToOne.Colaborador;
import br.andresgois.github.io.relacionamento.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorRepository repository;
    
    @GetMapping("/listar")
    public Iterable<Colaborador> list(){
        return repository.findAll();
    }
    
    @PostMapping("/cadastrar")
    public Colaborador cadastrar(@RequestBody Colaborador c){
        return repository.save(c);
    }
}
