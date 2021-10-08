package com.example.entrenamiento.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {

    @NotNull(message = "El nombre no puede se nulo")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    private double precio;

    private int cantidad;

}
