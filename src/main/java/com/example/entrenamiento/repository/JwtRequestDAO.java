package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.JwtRequest;
import org.springframework.data.repository.CrudRepository;

public interface JwtRequestDAO extends CrudRepository<JwtRequest,Integer> {
    JwtRequest findJwtRequestByUsername(String username);

}
