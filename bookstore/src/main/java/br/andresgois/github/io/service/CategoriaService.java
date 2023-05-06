package br.andresgois.github.io.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.andresgois.github.io.domain.Categoria;
import br.andresgois.github.io.repository.CategoriaRepository;
import br.andresgois.github.io.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> opt = categoriaRepository.findById(id);
        //return opt.orElse(null);
        return opt.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado Id: "+id));
    }
}
