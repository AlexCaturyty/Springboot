package br.com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoapi.projeto.model.Endereco;

public interface IEndereco extends JpaRepository<Endereco, Integer> {

	
    
}
