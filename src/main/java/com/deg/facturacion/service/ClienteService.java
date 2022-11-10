package com.deg.facturacion.service;

import ch.qos.logback.core.net.server.Client;
import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.repository.ClienteRepository;
import com.deg.facturacion.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //CREAR UN NUEVO CLIENTE
    public Cliente create (Cliente newCliente){
        return this.clienteRepository.save(newCliente);
    }


    //LEER O BUSCAR PERSONAS
    public List<ClienteResponse> findAll(){

        List<Cliente> entity= this.clienteRepository.findAll();
        List<ClienteResponse> response = new ArrayList<>();
        for (Cliente cliente :entity) {
            ClienteResponse clienteResponse = new ClienteResponse();
            clienteResponse.setId(cliente.getId());
            clienteResponse.setNombre(cliente.getNombre());
            clienteResponse.setApellido(cliente.getApellido());
            clienteResponse.setDni(cliente.getDni());
            clienteResponse.setEdad(getEdadFromFechaDeNacimiento(cliente.getFecha_nacimiento()));

            response.add(clienteResponse);
        }
        return response;
    }
    // Metodo para saber la edad de la persona
    private Integer getEdadFromFechaDeNacimiento( Date fechaDeNacimiento){

        if(fechaDeNacimiento != null){
            //return fechaDeNacimiento.getYear() -1900;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaDeNacimiento);
            Integer añoDeNacimiento = calendar.get(Calendar.YEAR);

            calendar.setTime(new Date());
            Integer añoActual = calendar.get(Calendar.YEAR);
            return añoActual - añoDeNacimiento ;
        }
            return null;

    }

    //ACTUALIZAR DATOS DE UN CLIENTE
    public Cliente update(Cliente cliente,Long id)  {   // throws ResourceNotFoundException
        Optional<Cliente> clienteBD = this.clienteRepository.findById(id);
        if (clienteBD.isPresent()){
            Cliente cli = clienteBD.get();
            cli.setApellido(cliente.getApellido());
            cli.setNombre(cliente.getNombre());
            return this.clienteRepository.save(cli);
        }else {
            return null;
            //throw new ResourceNotFoundException("El cliente no existe");
        }
    }

    // PARA ELIMINAR UN CLIENTE
    public void delete(Long id){
        this.clienteRepository.deleteById(id);

    }
}
