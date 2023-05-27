package io.github.andresgois.msclientes.infra.repository;

import io.github.andresgois.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
