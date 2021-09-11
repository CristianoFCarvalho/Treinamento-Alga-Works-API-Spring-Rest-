package com.algalogCristiano.algalogCristiano.domain.service;

import com.algalogCristiano.algalogCristiano.domain.model.Entrega;
import com.algalogCristiano.algalogCristiano.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;

public class BuscaEntregaService {

private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}


	



