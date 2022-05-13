package br.com.rotaract.secretaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patrocinadores")
@Entity
public class Patrocinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_patrocinador")
	private Long id;

	@Column(name = "valor")
	private Double valor_decimal;

	@Column(name = "Descricao")
	private String descricao;
	
	@Column(name = "nome_patrocinador")
	private String nome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getvalor_decimal() {
		return valor_decimal;
	}

	public void setvalor_decimal(Double valor_decimal) {
		this.valor_decimal = valor_decimal;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
