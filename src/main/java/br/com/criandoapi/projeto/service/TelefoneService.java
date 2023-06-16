package br.com.criandoapi.projeto.service;

import java.util.List;


import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.dto.TelefoneDTO;
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

	public Telefone criarTelefone(TelefoneDTO telefoneDTO) {
        Telefone telefone = new Telefone();
        telefone.atualizarDados(telefoneDTO);

        Telefone telefoneNovo = repository.save(telefone);
        return telefoneNovo;
    }
	

	public Telefone editarTelefone(TelefoneDTO telefoneDTO) {
        Telefone telefone = repository.findById(telefoneDTO.getId()).orElse(null);
        if (telefone != null) {
            telefone.atualizarDados(telefoneDTO);

            Telefone telefoneEditado = repository.save(telefone);
            return telefoneEditado;
        }
        return null;
    }
	   

	public Boolean excluirTelefone(Integer id) {
        repository.deleteById(id);
        return true;
    }


}