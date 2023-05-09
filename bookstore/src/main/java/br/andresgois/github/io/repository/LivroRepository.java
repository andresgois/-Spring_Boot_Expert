package br.andresgois.github.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.andresgois.github.io.domain.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :cat ORDER BY titulo")
    List<Livro> findAllByCategoria(@Param(value = "cat") Integer cat);
    
}
