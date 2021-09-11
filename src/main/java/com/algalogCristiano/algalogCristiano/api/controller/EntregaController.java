package com.algalogCristiano.algalogCristiano.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algalogCristiano.algalogCristiano.api.assembler.EntregaAssembler;
import com.algalogCristiano.algalogCristiano.api.model.EntregaModel;
import com.algalogCristiano.algalogCristiano.api.model.input.EntregaInput;
import com.algalogCristiano.algalogCristiano.domain.model.Entrega;
import com.algalogCristiano.algalogCristiano.domain.repository.EntregaRepository;
import com.algalogCristiano.algalogCristiano.domain.service.FinalizacaoEntregaService;
import com.algalogCristiano.algalogCristiano.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")

public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaImput ) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaImput);
		
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		return entregaAssembler.toModel(entregaSolicitada);
			
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long  entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
		
		
		
	@GetMapping
	public List<EntregaModel>listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
		
	}

		
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar (@PathVariable Long  entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());	
	}}
		
		
//					EntregaModel entregaModel = new EntregaModel ();
//					entregaModel.setId(entrega.getId());
//					entregaModel.setNomecliente(entrega.getCliente().getNome());
//					entregaModel.setDestinatario(new DestinatarioModel());
//					entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
//					entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//					entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//					entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//					entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//					entregaModel.setTaxa(entrega.getTaxa());
//					entregaModel.setStatus(entrega.getStatus());
//					entregaModel.setDataPedido(entrega.getDataPedido());
//					entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());
//					
					
				


