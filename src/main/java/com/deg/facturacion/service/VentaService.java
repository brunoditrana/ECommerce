package com.deg.facturacion.service;


import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.Venta;
import com.deg.facturacion.repository.ClienteRepository;
import com.deg.facturacion.repository.VentaRepository;
import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.response.VentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    //Crear una venta
    public Venta create (Venta newVenta){
        return this.ventaRepository.save(newVenta);
    }

    //Bucar por id FALTA

    //LEER O BUSCAR PERSONAS
    public List<VentaResponse> findAll(){

        List<Venta> entity= this.ventaRepository.findAll();
        List<VentaResponse> response = new ArrayList<>();
        for (Venta venta :entity) {
            VentaResponse ventaResponse = new VentaResponse();
            ventaResponse.setId(venta.getId());
            ventaResponse.setFecha_alta(venta.getFecha_alta());
            ventaResponse.setTotal(venta.getTotal());


            response.add(ventaResponse);
        }
        return response;
    }
}
