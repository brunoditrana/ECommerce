package com.deg.facturacion.model;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detalle_id")
    private Integer detalle_id;

    @Column
    private Integer cantidad;

    @Column(name = "sub_total")
    private Double sub_total;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta_id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto_id;


}
