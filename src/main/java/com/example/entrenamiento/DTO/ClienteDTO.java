package com.example.entrenamiento.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor

public class ClienteDTO {

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;


}
