package br.com.criandoapi.projeto.controller;

import java.util.List;


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

import br.com.criandoapi.projeto.model.Telefone;
import br.com.criandoapi.projeto.service.TelefoneService;

@RestController
@CrossOrigin("*")
@RequestMapping("/telefones")
public class TelefoneController {
	
	private TelefoneService telefoneService;
	
	public TelefoneController(TelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}
	
	@GetMapping
	public ResponseEntity<List<Telefone>> listatelefones() {
		return ResponseEntity.status(200).body(telefoneService.listarTelefone());
	}
	
	@PostMapping
	public ResponseEntity<Telefone> criarTelefone(@RequestBody Telefone telefone) {
		return ResponseEntity.status(201).body(telefoneService.criarTelefone(telefone));
	}
	
	@PutMapping
	public ResponseEntity<Telefone> editarTelefone(@RequestBody Telefone telefone) {
		return ResponseEntity.status(200).body(telefoneService.editarTelefone(telefone));
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Telefone> excluirTelefone (@PathVariable Integer id) {
    	telefoneService.excluirTelefone(id);
    	return ResponseEntity.status(204).build();
    }
	
	
}

   


