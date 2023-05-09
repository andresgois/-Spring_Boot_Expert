package br.andresgois.github.io.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.andresgois.github.io.domain.Categoria;
import br.andresgois.github.io.domain.Livro;
import br.andresgois.github.io.repository.CategoriaRepository;
import br.andresgois.github.io.repository.LivroRepository;
import br.andresgois.github.io.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private CategoriaService categoriaService;
    
    public Livro findLivroById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado, Id: "+id));
    }
    
    public List<Livro> findAll(Integer cat) {
        //return livroRepository.findAll();
        categoriaService.findById(cat);
        return livroRepository.findAllByCategoria(cat);
    }

    public Livro create(Livro obj) {
        obj.setId(null);
        return livroRepository.save(obj);
    }

    public Livro update(Integer id, Livro livro) {
        Livro newObj = findLivroById(id);
        updateData(newObj, livro);
        return livroRepository.save(livro);
    }

    private void updateData(Livro newObj, Livro livro) {
        newObj.setTitulo(livro.getTitulo());
        newObj.setNome_aut(livro.getNome_aut());
        newObj.setTexto(livro.getTexto());
    }
    
    public Livro createComCategoria(Integer id, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(id);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }
}
