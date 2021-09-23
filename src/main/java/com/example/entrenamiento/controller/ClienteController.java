package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @ResponseBody
    @GetMapping("/clientes")
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();    }


    @PostMapping("/clientes")
    public void insertCliente(@RequestBody ClienteDTO cliente) {
      clienteService.AddCliente(cliente);    }

    @GetMapping("/clientes/{idcliente}")
    public ClienteDTO getProductById(@PathVariable ("idcliente")int idcliente){

        return clienteService.getClienteDTOById(idcliente);
    }
    @PutMapping("/clientes/{idcliente}")
    public void updateCliente(@PathVariable ("idcliente") int idcliente, @RequestBody ClienteDTO clienteDTO){
        clienteService.updateCliente(idcliente, clienteDTO);

    }

    @DeleteMapping("/clientes/{idcliente}")
    public ResponseEntity<Cliente> DeleteProducto(@PathVariable ("idcliente") int idcliente){
        clienteService.deletecliente(idcliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
