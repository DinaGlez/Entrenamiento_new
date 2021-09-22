package com.example.entrenamiento.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {

    @NotNull(message = "El nombre no puede se nulo")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    private float precio;

    private int cantidad;

}
