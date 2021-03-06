package br.com.rotaract.secretaria.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatrocinadorDto {

	@NotNull
	private Double valorDecimal;
	
	@NotNull
	@Size(max = 2000, message = "A Descrição deve ter no máximo 2000 caracteres")
	private String descricao;
	
	@NotNull
	@Size(min = 1, max = 50, message = "O nome deve ter no máximo 50 caracteres")
	private String nome;
	
	public Double getValorDecimal() {
		return valorDecimal;
	}

	public void setValorDecimal(Double valorDecimal) {
		this.valorDecimal = valorDecimal;
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
