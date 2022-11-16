package com.deg.facturacion.response;


import com.deg.facturacion.model.Producto;
import com.deg.facturacion.model.Venta;
import lombok.Data;

import javax.persistence.Column;

@Data
public class DetalleVentaResponse {

    private Long id;


    private Integer detalle_id;


    private Integer cantidad;


    private Double sub_total;

    private Venta venta_id;

    private Producto producto_id;
}
