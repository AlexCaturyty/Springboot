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
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
	}
	
	@DeleteMapping
	public ResponseEntity<?> excluirUsuario(@RequestBody Usuario usuario) {
	    boolean excluido = usuarioService.excluirUsuario(usuario.getNome(), usuario.getSenha());
	    if (excluido) {
	        return ResponseEntity.status(204).build();
	    } else {
	        return ResponseEntity.status(404).build();
	    }
	}


	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario usuario) {
		Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getNome(), usuario.getSenha());
		if (usuarioAutenticado != null) {
			return ResponseEntity.status(200).body(usuarioAutenticado);
		} else {
			return ResponseEntity.status(401).build();
		}
	}
	
}

   

