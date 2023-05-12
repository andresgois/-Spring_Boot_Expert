package br.andresgois.github.io.relacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.andresgois.github.io.relacionamento.model.OneToMany.Postagem;

@Repository
public interface PostagemRepository extends CrudRepository<Postagem,  Long> {
    
}
