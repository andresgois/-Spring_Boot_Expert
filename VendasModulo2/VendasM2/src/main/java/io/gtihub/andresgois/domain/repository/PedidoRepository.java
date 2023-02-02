package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente c);
}
