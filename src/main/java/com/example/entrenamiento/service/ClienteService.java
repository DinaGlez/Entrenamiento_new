package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Venta;


import java.util.ArrayList;
import java.util.List;
public interface ClienteService {
    void AddCliente(ClienteDTO clienteDTO) ;
    List<ClienteDTO> getAll() ;
    void updateCliente(int id, ClienteDTO cliente);
    ClienteDTO getClienteDTOById(int idcliente);
    Cliente getClienteById(int idcliente);

    void deletecliente (int idcliente);

}
