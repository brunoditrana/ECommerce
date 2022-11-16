package com.deg.facturacion.controller;


import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.DetalleVenta;
import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.response.DetalleVentaResponse;
import com.deg.facturacion.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/detalle_venta")
@RestController
public class DetalleVentaController {

        @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping("/")
    public ResponseEntity<DetalleVenta> create(@RequestBody DetalleVenta detalleVenta){
        return new ResponseEntity<>(this.detalleVentaService.create(detalleVenta), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DetalleVentaResponse>> find(){
        return new ResponseEntity<>(this.detalleVentaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> findById(@PathVariable("id") Long id){
        Optional<DetalleVenta> optionalDetalleVenta = detalleVentaService.findById(id);
        if(optionalDetalleVenta.isPresent()){
            return new ResponseEntity(this.detalleVentaService.findById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
