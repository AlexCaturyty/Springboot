package br.com.criandoapi.projeto.service;

import java.util.List;


import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.model.Telefone;
import br.com.criandoapi.projeto.repository.ITelefone;

@Service
public class TelefoneService {

	private ITelefone repository;

	public TelefoneService(ITelefone repository) {
		this.repository = repository;
	}

	public List<Telefone> listarTelefone() {
		List<Telefone> lista = repository.findAll();
		return lista;
	}

	public Telefone criarTelefone(Telefone Telefone) {
		Telefone TelefoneNovo = repository.save(Telefone);
		return TelefoneNovo;
	}

	public Telefone editarTelefone(Telefone Telefone) {
		Telefone TelefoneNovo = repository.save(Telefone);
		return TelefoneNovo;
	}

	public Boolean excluirTelefone(Integer id) {
        repository.deleteById(id);
        return true;
    }


}