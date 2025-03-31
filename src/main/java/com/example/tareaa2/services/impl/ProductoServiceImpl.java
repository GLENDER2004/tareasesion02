package com.example.tareaa2.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tareaa2.domain.Producto;
import com.example.tareaa2.repositories.ProductoRepository;
import com.example.tareaa2.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository repository;

    @Transactional
    @Override
    public Producto create(Producto c) {
        return repository.save(c);
        
    }

    @Transactional
    @Override
    public Producto update(Producto c) {
        if (repository.existsById(c.getId())){
               return repository.save(c);
        }
        return null;
    }
   @Transactional
    @Override
    public void delete(Long id) {
        // Verifica si el producto existe antes de eliminarlo
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            // Puedes lanzar una excepción aquí si el producto no existe
            throw new IllegalArgumentException("Producto no encontrado");
        }    
    }

    @Override
    public Optional<Producto> read(Long id) {
        return repository.findById(id);
       
    }

    @Override
    public List<Producto> readAll() {
        return (List<Producto>) repository.findAll();
        
    }

}
