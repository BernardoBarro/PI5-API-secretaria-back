package br.com.rotaract.secretaria.dto;

import javax.validation.constraints.Size;

public class InstituicaoDto {

	@Size(max = 50, message = "O campo nome deve ter no máximo 50 caracteres")
	private String nome;
	
	@Size(min = 11, max = 11)
	private String contato;
	
	public String getNome() {
		return nome;
	}

	public String getContato() {
		return contato;
	}
	
}