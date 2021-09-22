package com.example.entrenamiento.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProductoVentaDTO {
    int idproducto;
    @NotNull(message = "La existencia no puede ser nula")
    private int cantidad;
}
