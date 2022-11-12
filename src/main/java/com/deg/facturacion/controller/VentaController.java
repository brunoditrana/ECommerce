package com.deg.facturacion.controller;

import com.deg.facturacion.model.Venta;
import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.response.VentaResponse;
import com.deg.facturacion.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/venta")
@RestController
public class VentaController {


    @Autowired
    private VentaService ventaService;

    @PostMapping("/")
    public ResponseEntity<Venta> create(Venta venta){               //(@RequestBody Venta venta){
        return new ResponseEntity<>(this.ventaService.create(venta), HttpStatus.OK);
    }


    //Endpoint para consultar en la base
    @GetMapping("/")
    public ResponseEntity<List<VentaResponse>> findAll(){
        return new ResponseEntity<>(this.ventaService.findAll(), HttpStatus.OK);
    }

}
