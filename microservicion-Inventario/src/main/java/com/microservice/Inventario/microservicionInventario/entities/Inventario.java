package com.microservice.Inventario.microservicionInventario.entities;

import jakarta.persistence.*;


import java.util.HashMap;
import java.util.Map;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "inventario_productos", joinColumns = @JoinColumn(name = "inventario_id"))
    @MapKeyColumn(name = "producto_id")
    @Column(name = "cantidad_disponible")
    private Map<Long, Integer> productos = new HashMap<>();

    public void actualizarCantidadProducto(Long idProducto, int cantidad) {
        this.productos.put(idProducto, cantidad);
    }

    // Constructor, getters y setters
}