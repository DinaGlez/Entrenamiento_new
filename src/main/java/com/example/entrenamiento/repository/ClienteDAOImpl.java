package com.example.entrenamiento.repository;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
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
public abstract class ClienteDAOImpl implements ClienteDAO {


}


