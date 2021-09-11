package com.algalogCristiano.algalogCristiano.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algalogCristiano.algalogCristiano.domain.model.StatusEntrega;



public class EntregaModel {

	private Long id;
	private ClienteResumoModel Cliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public DestinatarioModel getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(DestinatarioModel destinatario) {
		this.destinatario = destinatario;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	public StatusEntrega getStatus() {
		return status;
	}
	public void setStatus(StatusEntrega status) {
		this.status = status;
	}
	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public ClienteResumoModel getCliente() {
		return Cliente;
	}
	public void setCliente(ClienteResumoModel cliente) {
		Cliente = cliente;
	}
	public void setNomecliente(String nome) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
