package com.deg.facturacion.response;


import com.deg.facturacion.model.DetalleVenta;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductoResponse {

    private Long id;


    private String descripcion;


    private Double precio_compra;


    private Double precio_venta;


    private Integer stock;


    private Date fecha_alta;


   // private List<DetalleVenta> detalleVentas;


}
