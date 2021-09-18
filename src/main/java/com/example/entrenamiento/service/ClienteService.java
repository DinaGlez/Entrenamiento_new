package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Venta;


import java.util.ArrayList;
import java.util.List;
public interface ClienteService {
    void insertCliente(Cliente cliente);
    void AddCliente(ClienteDTO clienteDTO) ;
    List<ClienteDTO> getAll() ;
}
