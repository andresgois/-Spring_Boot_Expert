package br.andresgois.github.io.relacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.andresgois.github.io.relacionamento.model.ManyToMany.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso,  Long> {
    
}
