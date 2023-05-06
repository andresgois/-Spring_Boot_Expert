package br.andresgois.github.io.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.andresgois.github.io.domain.Categoria;
import br.andresgois.github.io.dtos.CategoriaDTO;
import br.andresgois.github.io.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService categoriaService; 
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findByIdCategoria(@PathVariable Integer id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok(obj);
    }
    
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> obj = categoriaService.findAll();
        List<CategoriaDTO> objDto = obj.stream().map(item -> new CategoriaDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok(objDto);
    }
}
