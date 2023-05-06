package br.andresgois.github.io.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.andresgois.github.io.domain.Categoria;
import br.andresgois.github.io.domain.Livro;
import br.andresgois.github.io.repository.CategoriaRepository;
import br.andresgois.github.io.repository.LivroRepository;

@Service
public class DBService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
    
    public void criarInstancia() {
        Categoria cat1 = new Categoria(null, "Informatica", "Livro de T.I");
        Categoria cat2 = new Categoria(null, "Religião", "Palavras religiosas e historias");
        Categoria cat3 = new Categoria(null, "Anime", "Livro de animes e mangás");
        Categoria cat4 = new Categoria(null, "Terror", "Livros com historias de assombração");
        
        Livro liv1 = new Livro(null, "Clean Code", "Robert c. martin", "Lorem ipsum", cat1);
        Livro liv2 = new Livro(null, "Nunca foi segredo: A sabedoria de Milênios em 60 ensinamentosNunca foi segredo: A sabedoria de Milênios em 60 ensinamentosNunca foi segredo: A sabedoria", "Pe. Reginaldo Manzotti", "Lorem ipsum", cat2);
        Livro liv3 = new Livro(null, "Neon Genesis Evangelion Collector's Edition VolNeon Genesis Evangelion Collector's Edition Vol. 02Neon Genesis Evangelion", "Yoshiyuki Sadamoto", "Lorem ipsum", cat3);
        
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        livroRepository.saveAll(Arrays.asList(liv1,liv2,liv3));
    }
}

