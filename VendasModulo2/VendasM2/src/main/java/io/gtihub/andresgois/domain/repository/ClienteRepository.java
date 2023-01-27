package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente c){
        entityManager.persist(c);
        return c;
    }

    @Transactional
    public Cliente atualizar(Cliente c){
        entityManager.merge(c);
        return c;
    }

    @Transactional
    public void remover(Cliente c){
        if(!entityManager.contains(c)){
            c = entityManager.merge(c);
        }
        entityManager.remove(c);
    }

    @Transactional
    public void remover(Integer id){
        Cliente cli = entityManager.find(Cliente.class, id);
        remover(cli);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscaPorNome(String nome){
        String jpql = " select c from cliente c where c.nome like :nome ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%"+nome+"%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Cliente> obterTodos(){
        return entityManager
                .createQuery(" from cliente", Cliente.class)
                .getResultList();
    }

}
