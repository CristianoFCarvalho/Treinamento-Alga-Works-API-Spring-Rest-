package com.algalogCristiano.algalogCristiano.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algalogCristiano.algalogCristiano.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{


	

	List<Cliente> findByNome(String nome);
	
}


