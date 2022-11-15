package com.deg.facturacion.controller;

import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.Venta;
import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.response.VentaResponse;
import com.deg.facturacion.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/venta")
@RestController
public class VentaController {


    @Autowired
    private VentaService ventaService;

    @PostMapping("/")
    public ResponseEntity<Venta> create(@RequestBody Venta venta){               //(@RequestBody Venta venta){
        return new ResponseEntity<>(this.ventaService.create(venta), HttpStatus.OK);
    }


    //Endpoint para consultar en la base
    @GetMapping("/")
    public ResponseEntity<List<VentaResponse>> find(){
        return new ResponseEntity<>(this.ventaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Long id){
        Optional<Venta> optionalCliente = ventaService.findById(id);
        if(optionalCliente.isPresent()){
            return new ResponseEntity(this.ventaService.findById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
