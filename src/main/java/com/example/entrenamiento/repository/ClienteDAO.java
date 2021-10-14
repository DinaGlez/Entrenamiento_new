package com.example.entrenamiento.repository;

import com.example.entrenamiento.DTO.ClienteDTO;
import com.example.entrenamiento.DTO.DetalleVentaDTO;
import com.example.entrenamiento.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;


public interface ClienteDAO extends ReactiveCrudRepository<Cliente,Integer> {

   }
