package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
