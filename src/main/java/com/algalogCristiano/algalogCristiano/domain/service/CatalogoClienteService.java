package com.algalogCristiano.algalogCristiano.domain.service;

import org.springframework.stereotype.Service;
import com.algalogCristiano.algalogCristiano.domain.model.Cliente;
import com.algalogCristiano.algalogCristiano.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow();
	}
	
	
	}

