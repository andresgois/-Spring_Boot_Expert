package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente c){
        entityManager.persist(c);
        return c;
    }
}
