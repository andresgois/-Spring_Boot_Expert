package br.andresgois.github.io.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.andresgois.github.io.domain.Livro;
import br.andresgois.github.io.dtos.LivroDTO;
import br.andresgois.github.io.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {
    
    @Autowired
    private LivroService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findLivroById(@PathVariable Integer id){
        Livro liv = service.findLivroById(id);
        return ResponseEntity.ok().body(liv);
    }
    
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(){
        List<Livro> liv = service.findAll();
        List<LivroDTO> opt = liv.stream().map( item -> new LivroDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok().body(opt);
    }
    
}
