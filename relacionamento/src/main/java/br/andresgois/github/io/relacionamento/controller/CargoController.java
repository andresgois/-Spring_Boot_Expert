package br.andresgois.github.io.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.andresgois.github.io.relacionamento.model.OneToOne.Cargo;
import br.andresgois.github.io.relacionamento.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    
    @Autowired
    private CargoRepository repository;
    
    @GetMapping("/listar")
    public Iterable<Cargo> list(){
        return repository.findAll();
    }
    
    @PostMapping("/cadastrar")
    public Cargo cadastrar(@RequestBody Cargo c){
        return repository.save(c);
    }
}
