package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Integer> {
}
