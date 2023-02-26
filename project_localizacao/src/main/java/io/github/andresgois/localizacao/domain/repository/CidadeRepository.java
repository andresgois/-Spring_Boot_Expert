package io.github.andresgois.localizacao.domain.repository;

import io.github.andresgois.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String n);

    List<Cidade> findByNomeStartingWith(String n);
    List<Cidade> findByNomeEndingWith(String n);
    List<Cidade> findByNomeContaining(String n);

    List<Cidade> findByHabitante(Long h);
}
