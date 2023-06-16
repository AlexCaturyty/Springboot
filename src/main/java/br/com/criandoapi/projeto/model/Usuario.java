package br.com.criandoapi.projeto.model;

import br.com.criandoapi.projeto.dto.UsuarioDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 200, nullable = true)
    private String nome;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Telefone telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void atualizarDados(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();

        // Verificar se o usuárioDTO contém informações de endereço e telefone
        if (usuarioDTO.getEndereco() != null) {
            if (this.endereco == null) {
                this.endereco = new Endereco();
            }
            this.endereco.setLogradouro(usuarioDTO.getEndereco().getLogradouro());
            this.endereco.setNumero(usuarioDTO.getEndereco().getNumero());
            this.endereco.setCep(usuarioDTO.getEndereco().getCep());
        }

        if (usuarioDTO.getTelefone() != null) {
            if (this.telefone == null) {
                this.telefone = new Telefone();
            }
            this.telefone.setDdd(usuarioDTO.getTelefone().getDdd());
            this.telefone.setNumero(usuarioDTO.getTelefone().getNumero());
        }
    }

}