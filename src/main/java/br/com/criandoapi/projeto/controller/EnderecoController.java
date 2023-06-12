package br.com.criandoapi.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.criandoapi.projeto.model.Endereco;
import br.com.criandoapi.projeto.service.EnderecoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/enderecos")
public class EnderecoController {
    
	
    private EnderecoService enderecoService;
    
    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Endereco>> listaEnderecos() {
        List<Endereco> enderecos = enderecoService.listarEndereco();
        return ResponseEntity.status(200).body(enderecos);
    }
    
    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoCriado = enderecoService.criarEndereco(endereco);
        return ResponseEntity.status(201).body(enderecoCriado);
    }
    
    @PutMapping
    public ResponseEntity<Endereco> editarEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoEditado = enderecoService.editarEndereco(endereco);
        return ResponseEntity.status(200).body(enderecoEditado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEndereco (@PathVariable Integer id) {
    	enderecoService.excluirEndereco(id);
    	return ResponseEntity.status(204).build();
    }

}





	


   

