package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.ClienteTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

    private static final String INSERT = "INSERT INTO cliente_teste (id, nome) values (?,?)";
    private static final String SELECT_ALL = "SELECT * FROM cliente_teste";
    private static final String SELECT_POR_ID = "SELECT * FROM cliente_teste WHERE id = ?";
    private static final String UPDATE = "UPDATE cliente_teste SET nome = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM cliente_teste WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ClienteTeste salvaCliente(ClienteTeste clienteTeste){
        jdbcTemplate.update(INSERT, new Object[]{clienteTeste.getId(), clienteTeste.getNome()});
        return clienteTeste;
    }

    public ClienteTeste atualizar(ClienteTeste clienteTeste){
        jdbcTemplate.update(UPDATE, new Object[]{clienteTeste.getNome(), clienteTeste.getId()});
        return clienteTeste;
    }

    public List<ClienteTeste> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, getClienteMapper());
    }

    public List<ClienteTeste> buscaPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ?"),
                new Object[]{ "%"+ nome + "%"},
                getClienteMapper());
    }

    private static RowMapper<ClienteTeste> getClienteMapper() {
        return new RowMapper<ClienteTeste>() {
            @Override
            public ClienteTeste mapRow(ResultSet resultSet, int i) throws SQLException {
                return new ClienteTeste(resultSet.getInt("id"), resultSet.getString("nome"));
            };
        };
    }

    public void deletar(ClienteTeste clienteTeste){
        deletar(clienteTeste.getId());
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

}
