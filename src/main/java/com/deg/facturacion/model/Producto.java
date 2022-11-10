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
    @GeneratedValue
    private Long id;

    @Column
    private String descripcion;

    @Column(name = "precioCompra")
    private Double precioCompra;

    @Column(name = "precioVenta")
    private Double precioVenta;

    @Column
    private Integer stock;

    @Column(name = "fecha_alta")
    private Date fecha_alta;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;


}
