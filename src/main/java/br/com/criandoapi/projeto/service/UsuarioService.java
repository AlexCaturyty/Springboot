package br.com.criandoapi.projeto.service;

import java.util.List;


import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.dto.UsuarioDTO;
import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

@Service
public class UsuarioService {

	private IUsuario repository;

	public UsuarioService(IUsuario repository) {
		this.repository = repository;
	}

	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}

	public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.atualizarDados(usuarioDTO);

        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }


	public Usuario editarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = repository.findById(usuarioDTO.getId()).orElse(null);
        if (usuario != null) {
            usuario.atualizarDados(usuarioDTO);

            Usuario usuarioEditado = repository.save(usuario);
            return usuarioEditado;
        }
        return null;
    }

	public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }




	

}