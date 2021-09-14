package com.example.entrenamiento.dao;

import com.example.entrenamiento.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class ClienteDAOImpl extends JdbcDaoSupport implements ClienteDAO{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insertCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente " + "(apellido, dni,email,nombre,telefono) VALUES (?, ?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[] { cliente.getApellido(), cliente.getDni(),cliente.getEmail(),cliente.getNombre(),cliente.getTelefono() });

    }
}


