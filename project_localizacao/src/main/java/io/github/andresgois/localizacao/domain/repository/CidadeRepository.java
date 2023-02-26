package io.github.andresgois.localizacao.domain.repository;

import io.github.andresgois.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
