package br.andresgois.github.io.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.andresgois.github.io.domain.Livro;
import br.andresgois.github.io.repository.LivroRepository;
import br.andresgois.github.io.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;
    
    public Livro findLivroById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado, Id: "+id));
    }
    
    
}
