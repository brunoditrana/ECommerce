package com.deg.facturacion.response;

import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.DetalleVenta;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class VentaResponse {




    private Long id;


    private Date fecha_alta;


    private Double total;


    private Cliente cliente_id;


   //private List<DetalleVenta> detalleVentas;


}
