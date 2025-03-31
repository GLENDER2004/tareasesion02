package com.example.tareaa2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tareaa2.domain.Producto;
import com.example.tareaa2.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    // Crear un producto
    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        Producto createdProducto = productoService.create(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> read(@PathVariable Long id) {
        Optional<Producto> producto = productoService.read(id);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> readAll() {
        List<Producto> productos = productoService.readAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id); // Asegurarse de que el ID del producto es el correcto
        Producto updatedProducto = productoService.update(producto);
        return updatedProducto != null ? new ResponseEntity<>(updatedProducto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            productoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // El recurso fue eliminado correctamente
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Producto no encontrado
        }
    }
}
