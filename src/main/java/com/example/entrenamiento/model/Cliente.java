package com.example.entrenamiento.model;


import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor

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
        private String telefono;
        @Email(message = "El correo no es valido", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
        private String email;

        @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
        private List<Venta> ventas=new ArrayList<>();

    @Override
    public String toString() {
        return "Cliente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" +dni+"]";
    }


}
