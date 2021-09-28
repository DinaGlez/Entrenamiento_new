package com.example.entrenamiento.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idproducto;
    @NotNull(message = "El nombre no puede se nulo")
    @NotEmpty(message = "El nombre no puede estar vacio")
    @NotBlank(message = "El nombre no puede quedar en blanco")
    private String nombre;
    @NotNull(message = "El precio no puede ser nulo")
    private double precio;
    @NotNull(message = "La cantidad no puede ser nula")
    private int cantidad;


    @OneToMany(mappedBy = "Producto")
    private List<DetalleVenta> detalles=new ArrayList<>();

    @Override
   public String toString() {
        return "Producto [Identificador=" + idproducto + ", nombre=" + nombre + ", precio="+precio+"]";
   }

}
