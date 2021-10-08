package com.example.entrenamiento.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor // <--- THIS is it
@AllArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @NotNull(message = "La cantidad no puede se nula")
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idventa", nullable = false)
    private Venta venta;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproducto", nullable = false)
    private Producto Producto;

}
