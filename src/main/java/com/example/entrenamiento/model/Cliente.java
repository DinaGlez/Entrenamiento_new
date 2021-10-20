package com.example.entrenamiento.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public class Cliente implements  Serializable {
        @Id
        private String idcliente;
        private String nombre;
        private String apellido;
        private String dni;
        private String telefono;
        private String email;


    @Override
    public String toString() {
        return "Cliente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" +dni+"]";
    }


}
