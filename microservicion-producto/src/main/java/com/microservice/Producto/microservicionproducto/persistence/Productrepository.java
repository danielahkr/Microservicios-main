package com.microservice.Producto.microservicionproducto.persistence;

import com.microservice.Producto.microservicionproducto.entities.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Productrepository extends CrudRepository<Producto, Long> {


}
