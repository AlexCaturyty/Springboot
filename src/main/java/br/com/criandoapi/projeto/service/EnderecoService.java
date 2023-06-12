package br.com.criandoapi.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.model.Endereco;
import br.com.criandoapi.projeto.repository.IEndereco;

@Service
public class EnderecoService {

    private IEndereco enderecoRepository;

    @Autowired
    public EnderecoService(IEndereco enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listarEndereco() {
        return enderecoRepository.findAll();
    }

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco editarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Boolean excluirEndereco(Integer id) {
        enderecoRepository.deleteById(id);
        return true;
    }


}
