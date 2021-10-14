package com.example.entrenamiento.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    @Id
    private Integer idproducto;
    private String nombre;
    private double precio;
    private int cantidad;



    @Override
   public String toString() {
        return "Producto [Identificador=" + idproducto + ", nombre=" + nombre + ", precio="+precio+"]";
   }

   }
