package br.com.rotaract.secretaria.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConvidadoDto {

	@NotNull
	@Size(max = 25, message = "O campo nome deve ter no máximo 50 caracteres")
	private String nome;
	
	@NotNull
	@Size(max = 25, message = "O campo contato deve ter no máximo 25 caracteres")
	private String contato;
	
	public String getNome() {
		return nome;
	}

	public String getContato() {
		return contato;
	}
	
}