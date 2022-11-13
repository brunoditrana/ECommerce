package com.deg.facturacion.controller;


import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.response.ProductoResponse;
import com.deg.facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    //@PostMapping("/")


    @GetMapping("/")
    public ResponseEntity<List<ProductoResponse>> find(){
        return new ResponseEntity<>(this.productoService.findAll(), HttpStatus.OK);
    }
}
