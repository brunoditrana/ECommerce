package com.deg.facturacion.model;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "detalle_id")
    private Integer detalleId;

    @Column
    private Integer cantidad;

    @Column(name = "subtotal")
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;


}
