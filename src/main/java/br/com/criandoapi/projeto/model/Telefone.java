package br.com.criandoapi.projeto.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Telefone")

public class Telefone {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	private Integer id;
		@Column(name = "ddd", length = 200, nullable = true)
	private String ddd;
		@Column(name = "numero", length = 100, nullable = true)
	private String numero;
		
		@OneToOne(mappedBy = "telefone")
		private Usuario usuario;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}



		public String getDdd() {
			return ddd;
		}



		public void setDdd(String ddd) {
			this.ddd = ddd;
		}



		public String getNumero() {
			return numero;
		}



		public void setNumero(String numero) {
			this.numero = numero;
		}

		
}