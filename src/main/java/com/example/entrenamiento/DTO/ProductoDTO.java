package com.example.entrenamiento.DTO;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {


    private String nombre;
    private double precio;

    private int cantidad;

}
