package br.andresgois.github.io.relacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.andresgois.github.io.relacionamento.model.OneToOne.Colaborador;

@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador,  Long> {
    
}
