package com.example.entrenamiento.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idventa;
    @NotNull
    private Date fecha;

    private double importe;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles=new ArrayList<>();

    @Override
    public String toString() {
        return "Venta [Identificador=" + idventa + ", fecha=" + fecha + ", cliente="+cliente.getNombre() + cliente.getApellido()+"]";
    }

}
