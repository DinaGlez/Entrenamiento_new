package com.example.entrenamiento.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idproducto;
    @Column(length = 64, nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false)
    private float precio;

    @Override
   public String toString() {
        return "Producto [Identificador=" + idproducto + ", nombre=" + nombre + ", precio="+precio+"]";
   }

}
