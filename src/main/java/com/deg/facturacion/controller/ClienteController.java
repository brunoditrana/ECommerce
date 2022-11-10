package com.deg.facturacion.controller;


import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/facturacion") //Definiendo la base, directorio raiz
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    //Endpoint para crear un nuevo Cliente
    @PostMapping("/")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.OK );
    }

    //Endpoint para consultar en la base
    @GetMapping("/")
        public ResponseEntity<List<ClienteResponse>> findAll(){
        return new ResponseEntity<>(this.clienteService.findAll(), HttpStatus.OK);
    }

    //Endpoint para actualizar datos
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente clienteUpdate, @PathVariable Long id){
        return new ResponseEntity<>(this.clienteService.update(clienteUpdate, id),HttpStatus.OK );
    }
}
