package com.example.entrenamiento.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it

    public class Cliente implements  Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer idcliente;

        private String nombre;
        private String apellido;
        private String dni;
        private int telefono;

        private String email;


    @Override
    public String toString() {
        return "Cliente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" +dni+"]";
    }


}
