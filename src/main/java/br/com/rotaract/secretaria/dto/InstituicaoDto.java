package br.com.rotaract.secretaria.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InstituicaoDto {

	@NotNull
	@Size(max = 50, message = "O campo nome deve ter no máximo 50 caracteres")
	private String nome;

	@NotNull
	@Size(min = 11, max = 11)
	private String contato;

	private String detalhes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}