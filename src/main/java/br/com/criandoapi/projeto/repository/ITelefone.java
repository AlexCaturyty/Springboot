package br.com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoapi.projeto.model.Telefone;

public interface ITelefone extends JpaRepository<Telefone, Integer> {

    
}
