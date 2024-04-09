package com.microservice.Inventario.microservicionInventario.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InventarioNotFoundException extends RuntimeException {

    public InventarioNotFoundException(Long id) {
        super("Inventario no encontrado con el ID: " + id);
    }
}