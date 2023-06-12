package br.com.criandoapi.projeto.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")

public class Endereco {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	private Integer id;
		@Column(name = "logradouro", length = 200, nullable = true)
	private String logradouro;
		@Column(name = "numero", length = 100, nullable = true)
	private String numero;
		@Column(name = "cep", columnDefinition = "TEXT", nullable = true)
	private String cep;
		
		@OneToOne(mappedBy = "endereco")
		private Usuario usuario;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		
}
