package com.algalogCristiano.algalogCristiano.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalogCristiano.algalogCristiano.domain.model.Entrega;
import com.algalogCristiano.algalogCristiano.domain.model.StatusEntrega;
import com.algalogCristiano.algalogCristiano.domain.repository.EntregaRepository;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service


public class FinalizacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService ;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);

		
		
		
		
	}
}