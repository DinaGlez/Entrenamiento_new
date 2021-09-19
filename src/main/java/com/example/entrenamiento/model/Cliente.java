package com.example.entrenamiento.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it

    public class Cliente implements  Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer idcliente;
        @NotNull
        @NotEmpty
        private String nombre;
        @NotNull
        @NotEmpty
        private String apellido;
        @NotNull
        @NotEmpty
        private String dni;
        private int telefono;

        private String email;


    @Override
    public String toString() {
        return "Cliente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" +dni+"]";
    }


}
