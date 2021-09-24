package com.example.entrenamiento.service;

import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.model.Venta;
import com.example.entrenamiento.repository.ClienteDAO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.DTO.ClienteDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicioImpl implements ClienteService {
    @Autowired
    ClienteDAO clienteDAO;

    @Autowired
    private ModelMapper modelMapper;

    private ClienteDTO convertToClienteDTO(Cliente cliente){
       ClienteDTO clienteDTO=new ClienteDTO();
       clienteDTO.setNombre(cliente.getNombre());
       clienteDTO.setApellido(cliente.getApellido());
       clienteDTO.setDni(cliente.getDni());
       clienteDTO.setEmail(cliente.getEmail());
       clienteDTO.setTelefono(cliente.getTelefono());

       return clienteDTO;
    }

    @Override
    public void AddCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new ModelMapper().map(clienteDTO, Cliente.class);
        clienteDAO.save(cliente);

    }

    @Override
    public List<ClienteDTO> getAll() {
        return ((List<Cliente>) clienteDAO
                .findAll())
                .stream()
                .map(this::convertToCLienteDTO2)
                .collect(Collectors.toList());


    }

    @Override
    public void updateCliente(int id, ClienteDTO cliente) {
        Cliente cli = clienteDAO.findById(id).get();
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
        cli.setDni(cliente.getDni());
        cli.setTelefono(cliente.getTelefono());
        cli.setEmail(cliente.getEmail());

        Cliente clienteDTO = new ModelMapper().map(cli, Cliente.class);

        clienteDAO.save(clienteDTO);

    }

    @Override
    public ClienteDTO getClienteDTOById(int idcliente) {
        ClienteDTO clienteDTO = new ModelMapper().map(clienteDAO.findById(idcliente).get(), ClienteDTO.class);

        return clienteDTO;

    }

    @Override
    public Cliente getClienteById(int idcliente) {
        return clienteDAO.findById(idcliente).get();
    }

    @Override
    public List<DetalleVentaDTO> findDetalleVentaDtoList(int idcliente) {
        return null;
    }

    @Override
    public void deletecliente(int idcliente) {
        clienteDAO.deleteById(idcliente);
    }

    private ClienteDTO convertToCLienteDTO2(Cliente cliente) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ClienteDTO clienteDTO=modelMapper.map(cliente,ClienteDTO.class);
        return clienteDTO;
    }
}
