package com.deg.facturacion.response;

import com.deg.facturacion.model.Venta;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
public class ClienteResponse {



    private Long id;

    private String dni;


    private String nombre;


    private String apellido;


   private Integer edad;


  // private List<VentaResponse> ventas;

}
