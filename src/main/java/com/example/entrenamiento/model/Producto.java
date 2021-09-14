package com.example.entrenamiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it

public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idproducto;

    private String nombre;
    private float precio;

    @Override
   public String toString() {
        return "Producto [Identificador=" + idproducto + ", nombre=" + nombre + ", precio="+precio+"]";
   }

}
