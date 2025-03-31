package com.example.tareaa2.services;

import java.util.List;
import java.util.Optional;

import com.example.tareaa2.domain.Cliente;

public interface ClienteService {
   
   Cliente create(Cliente c);
   Cliente update(Cliente c);
	void delete(Long id);
	Optional<Cliente> read(Long id);
	List<Cliente> readAll();
   
}
