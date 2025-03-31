package com.example.tareaa2.services;

import java.util.List;
import java.util.Optional;

import com.example.tareaa2.domain.Pedido;



public interface PedidoService {
    
    Pedido create(Pedido c);
    Pedido update(Pedido c);
	void delete(Long id);
	Optional<Pedido> read(Long id);
	List<Pedido> readAll();
}
