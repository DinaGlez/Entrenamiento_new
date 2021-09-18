package com.example.entrenamiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it

public class DetalleVenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer inDetalleVenta;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto Producto;

}
