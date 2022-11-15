package com.deg.facturacion.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descripcion;

    @Column
    private Double precio_compra;

    @Column
    private Double precio_venta;

    @Column
    private Integer stock;

    @Column(name = "fecha_alta")
    private Date fecha_alta;

   // @OneToMany(mappedBy = "producto")
    // private List<DetalleVenta> detalleVentas;


}
