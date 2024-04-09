package com.microservice.Producto.microservicionproducto.Controller;

import com.microservice.Producto.microservicionproducto.entities.Producto;
import com.microservice.Producto.microservicionproducto.persistence.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private Productrepository productoRepository;

    @GetMapping("/")
    public Iterable<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping("/crear")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/search/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @GetMapping("/search-by-product/{id}")
    public ResponseEntity<?> findProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(productoRepository.findById(id).orElseThrow(() -> new ProductoNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        productoRepository.delete(producto);
    }
}