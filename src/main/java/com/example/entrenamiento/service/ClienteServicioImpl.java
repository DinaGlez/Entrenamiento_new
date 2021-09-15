package com.example.entrenamiento.service;

import com.example.entrenamiento.repository.ClienteDAO;
import com.example.entrenamiento.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl implements ClienteService {
    @Autowired
    ClienteDAO clienteDAO;
    @Override
    public void insertCliente(Cliente cliente) {
           clienteDAO.insertCliente(cliente);
    }
}
