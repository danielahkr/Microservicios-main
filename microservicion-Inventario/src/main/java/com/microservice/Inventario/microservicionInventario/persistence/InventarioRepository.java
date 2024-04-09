package com.microservice.Inventario.microservicionInventario.persistence;

import com.microservice.Inventario.microservicionInventario.entities.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface InventarioRepository extends CrudRepository<Inventario, Long> {
}