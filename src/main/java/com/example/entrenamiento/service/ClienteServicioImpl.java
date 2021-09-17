package com.example.entrenamiento.service;

import com.example.entrenamiento.repository.ClienteDAO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.repository.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImpl implements ClienteService {
    @Autowired
    ClienteDAO clienteDAO;

    private ClienteDTO ConvertToClienteDTO(Cliente cliente){
       ClienteDTO clienteDTO=new ClienteDTO();
       clienteDTO.setNombre(cliente.getNombre());
       clienteDTO.setApellido(cliente.getApellido());
       clienteDTO.setDni(cliente.getDni());
       clienteDTO.setEmail(cliente.getEmail());
       clienteDTO.setTelefono(cliente.getTelefono());

       return clienteDTO;
    }
    @Override
    public void insertCliente(Cliente cliente) {
           clienteDAO.insertCliente(cliente);
    }
}
