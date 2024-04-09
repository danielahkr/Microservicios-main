package com.microservice.Inventario.microservicionInventario.Controller;

import com.microservice.Inventario.microservicionInventario.entities.Inventario;
import com.microservice.Inventario.microservicionInventario.persistence.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository inventarioRepository;

    @GetMapping("/")
    public Iterable<Inventario> getAllInventario() {
        return inventarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Inventario getInventarioById(@PathVariable Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new InventarioNotFoundException(id));
    }

    @PostMapping("/")
    public Inventario crearInventario(@RequestBody Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @PutMapping("/{id}/productos/{idProducto}")
    public Inventario actualizarCantidadProducto(@PathVariable Long id, @PathVariable Long idProducto, @RequestBody int cantidad) {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new InventarioNotFoundException(id));

        inventario.actualizarCantidadProducto(idProducto, cantidad);
        return inventarioRepository.save(inventario);
    }


}