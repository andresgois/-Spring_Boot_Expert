package br.andresgois.github.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.andresgois.github.io.domain.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{
    
}
