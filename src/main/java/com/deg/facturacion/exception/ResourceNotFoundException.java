package com.deg.facturacion.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
