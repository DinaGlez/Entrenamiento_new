package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class VentaDAOImpl extends JdbcDaoSupport implements VentaDAO {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public List<Venta> getVentas() {
        String sql = "SELECT * FROM venta";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Venta> result = new ArrayList<Venta>();
        for (Map<String, Object> row : rows) {
            Venta emp = new Venta();
            emp.setInVenta((Integer) row.get("in_venta"));
            emp.setFecha((Date) row.get("Fecha"));
            emp.setCliente((Cliente) row.get("idcliente"));

            result.add(emp);
        }

        return result;
    }

    @Override
    public void insertVenta(Venta venta) {
            String sql = "INSERT INTO venta " + "(in_venta, fecha,idcliente) VALUES (?, ?,?)";
            getJdbcTemplate().update(sql, new Object[] { venta.getInVenta(), venta.getFecha(),venta.getCliente().getIdcliente() });

        }
    }

