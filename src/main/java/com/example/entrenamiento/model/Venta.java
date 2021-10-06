package com.example.entrenamiento.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idventa;
    @NotNull
    private Date fecha;

    private double importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleVenta> detalles=new ArrayList<>();

    @Override
    public String toString() {
        return "Venta [Identificador=" + idventa + ", fecha=" + fecha + ", cliente="+cliente.getNombre() + cliente.getApellido()+"]";
    }

}
