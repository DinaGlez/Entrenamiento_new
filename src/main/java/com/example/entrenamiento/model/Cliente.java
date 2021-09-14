package com.example.entrenamiento.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.io.Serializable;


@Entity
    public class Cliente implements  Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer idcliente;

        private String nombre;
        private String apellido;
        private String dni;
        private String telefono;

        private String email;


        public Integer getIdcliente() {
            return idcliente;
        }

        public void setIdcliente(Integer idcliente) {
            this.idcliente = idcliente;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    @Override
    public String toString() {
        return "Cliente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" +dni+"]";
    }


}
