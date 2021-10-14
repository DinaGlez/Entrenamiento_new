package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.JwtRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface JwtRequestDAO extends ReactiveCrudRepository<JwtRequest,Integer> {
    JwtRequest findJwtRequestByUsername(String username);

}
