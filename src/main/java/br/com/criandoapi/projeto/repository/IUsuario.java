package br.com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoapi.projeto.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
    Usuario findByNome(String nome);
    Usuario findByNomeAndSenha(String nome, String senha);
}
