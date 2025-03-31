package com.example.tareaa2.services;

import java.util.List;
import java.util.Optional;

import com.example.tareaa2.domain.DetallePedido;


public interface DetallePedidoService {
 DetallePedido create(DetallePedido c);
 DetallePedido update(DetallePedido c);
	void delete(Long id);
	Optional<DetallePedido> read(Long id);
	List<DetallePedido> readAll();
}
