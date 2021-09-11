package com.algalogCristiano.algalogCristiano.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalogCristiano.algalogCristiano.domain.model.Cliente;
import com.algalogCristiano.algalogCristiano.domain.model.Entrega;
import com.algalogCristiano.algalogCristiano.domain.model.StatusEntrega;
import com.algalogCristiano.algalogCristiano.domain.repository.ClienteRepository;
import com.algalogCristiano.algalogCristiano.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service

public class SolicitacaoEntregaService {
	
	private ClienteRepository clienteRepository;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar (Entrega entrega) {
		Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
				.orElseThrow() ;
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
	
		
	return entregaRepository.save(entrega);
	

	


	
		
	}

	

	
}