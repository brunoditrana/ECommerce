package com.deg.facturacion.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "fecha_alta")
    private Date fecha_alta;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //@OneToMany(mappedBy = "venta")
    //private List<DetalleVenta> detalleVentas;


}
