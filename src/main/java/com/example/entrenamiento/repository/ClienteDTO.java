package com.example.entrenamiento.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ClienteDTO {

    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;

    private String email;


}
