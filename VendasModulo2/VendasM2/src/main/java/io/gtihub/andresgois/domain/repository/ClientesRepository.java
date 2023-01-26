package io.gtihub.andresgois.domain.repository;

import io.gtihub.andresgois.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

    private static final String INSERT = "INSERT INTO cliente (nome) values (?)";
    private static final String SELECT_ALL = "SELECT * FROM cliente";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvaCliente(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getString("nome"));
            };
        });
    }
}
