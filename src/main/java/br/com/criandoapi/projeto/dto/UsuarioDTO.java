package br.com.criandoapi.projeto.dto;

public class UsuarioDTO {
	private Integer id;
    private String nome;
    private String senha;
    private String email;
    private EnderecoDTO endereco;
    private TelefoneDTO telefone;

    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public TelefoneDTO getTelefone() {
        return telefone;
    }

    public void setTelefone(TelefoneDTO telefone) {
        this.telefone = telefone;
    }
	
}