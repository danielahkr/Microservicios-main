package com.microservice.Inventario.microservicionInventario.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc-Product", url = "localhost:8090/productos")
public interface ProductoCliente {
    @GetMapping("/search-by-product/{id}")
    List<?> findAllProductosbyCourse(@PathVariable long id);
}
