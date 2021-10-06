package com.example.entrenamiento.controller;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    private static final Logger LOG = LogManager.getLogger("cliente");

    @ResponseBody
    @GetMapping("/clientes")
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();    }


    @PostMapping("/clientes")
    public ResponseEntity<?> insertCliente(@RequestBody ClienteDTO cliente) {
      clienteService.AddCliente(cliente);
      LOG.info("Insserción del cliente: "+ cliente.getNombre()+" "+cliente.getApellido());
       return ResponseEntity.ok(cliente);
    }

    @GetMapping("/clientes/{idcliente}")
    public ClienteDTO getProductById(@PathVariable ("idcliente")int idcliente){

        return clienteService.getClienteDTOById(idcliente);
    }
    @PutMapping("/clientes/{idcliente}")
    public ResponseEntity<?> updateCliente(@PathVariable ("idcliente") int idcliente, @RequestBody ClienteDTO clienteDTO){
        clienteService.updateCliente(idcliente, clienteDTO);

    return ResponseEntity.ok(clienteService.getClienteDTOById(idcliente));
    }

    @DeleteMapping("/clientes/{idcliente}")
    public ResponseEntity<Cliente> DeleteProducto(@PathVariable ("idcliente") int idcliente) throws Exception {
      try {
          clienteService.deletecliente(idcliente);
      }catch (Exception e){
          throw new Exception("Imposible borrar cliente, tiene ventas asociadas", e.getCause());
      }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
