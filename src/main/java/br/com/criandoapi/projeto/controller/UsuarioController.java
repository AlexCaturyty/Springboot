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

import br.com.criandoapi.projeto.dto.UsuarioDTO;
import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios() {
		return ResponseEntity.status(200).body(usuarioService.listarUsuario());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
	    return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuarioDTO));
	}

	
	 @PutMapping
	 public ResponseEntity<Usuario> editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
	     return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuarioDTO));
	 }


	
	@DeleteMapping("/{id}")
    public ResponseEntity<Usuario> excluirUsuario (@PathVariable Integer id) {
    	usuarioService.excluirUsuario(id);
    	return ResponseEntity.status(204).build();
    }



	
	
	
}