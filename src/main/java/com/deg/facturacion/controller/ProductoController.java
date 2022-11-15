package com.deg.facturacion.controller;


import com.deg.facturacion.exception.ResourceAlreadyExistsException;
import com.deg.facturacion.exception.ResourceNotFoundException;
import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.Producto;

import com.deg.facturacion.model.Venta;
import com.deg.facturacion.response.ProductoResponse;
import com.deg.facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @PostMapping("/")
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        return new ResponseEntity<>(this.productoService.create(producto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductoResponse>> find(){
        return new ResponseEntity<>(this.productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Long id){
        Optional<Producto> optionalProducto = productoService.findById(id);
        if(optionalProducto.isPresent()){
            return new ResponseEntity(this.productoService.findById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto productoUpdate, @PathVariable("id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productoService.update(productoUpdate, id),HttpStatus.OK );
    }
}
