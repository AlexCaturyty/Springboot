package br.com.criandoapi.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.dto.EnderecoDTO;
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

    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Endereco telefone = new Endereco();
        telefone.atualizarDados(enderecoDTO);

        Endereco telefoneNovo = enderecoRepository.save(telefone);
        return telefoneNovo;
    }


	public Endereco editarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.findById(enderecoDTO.getId()).orElse(null);
        if (endereco != null) {
            endereco.atualizarDados(enderecoDTO);

            Endereco enderecoEditado = enderecoRepository.save(endereco);
            return enderecoEditado;
        }
        return null;
    }

    public Boolean excluirEndereco(Integer id) {
        enderecoRepository.deleteById(id);
        return true;
    }


}
