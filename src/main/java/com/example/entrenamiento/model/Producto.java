package com.example.entrenamiento.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idproducto;

    private String nombre;
    private float precio;

    @Override
   public String toString() {
        return "Producto [Identificador=" + idproducto + ", nombre=" + nombre + ", precio="+precio+"]";
   }

}
