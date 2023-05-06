package br.andresgois.github.io.service;

import java.util.List;
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

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }
    
    public Categoria update(Integer id, Categoria categoria) {
        Categoria obj = findById(id);
        obj.setNome(categoria.getNome());
        obj.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }
}
