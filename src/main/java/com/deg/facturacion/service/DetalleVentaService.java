package com.deg.facturacion.service;


import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.DetalleVenta;
import com.deg.facturacion.model.Venta;
import com.deg.facturacion.repository.DetalleVentaRepository;
import com.deg.facturacion.response.DetalleVentaResponse;
import com.deg.facturacion.response.VentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    // CREAR UN DETALLE VENTA
    public DetalleVenta create(DetalleVenta newDetalleVenta) {
        return this.detalleVentaRepository.save(newDetalleVenta);
    }

    //LEER O BUSCAR PERSONAS
    public List<DetalleVentaResponse> findAll(){

        List<DetalleVenta> entity= this.detalleVentaRepository.findAll();
        List<DetalleVentaResponse> response = new ArrayList<>();
        for (DetalleVenta detalleVenta :entity) {
            DetalleVentaResponse detalleVentaRes = new DetalleVentaResponse();
            detalleVentaRes.setId(detalleVentaRes.getId());
            detalleVentaRes.setDetalle_id(detalleVentaRes.getDetalle_id());
            detalleVentaRes.setSub_total(detalleVentaRes.getSub_total());


            response.add(detalleVentaRes);
        }
        return response;
    }
    // BUSCAR POR ID
    public Optional<DetalleVenta> findById(Long id) {

        return this.detalleVentaRepository.findById(id);


    }

}
