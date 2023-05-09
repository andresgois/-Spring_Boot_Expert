package br.andresgois.github.io.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        List<Livro> liv = service.findAll(id_cat);
        List<LivroDTO> opt = liv.stream().map( item -> new LivroDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok().body(opt);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro){
        service.update(id, livro);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro livro){
        service.update(id, livro);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro obj){
        Livro newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
}
