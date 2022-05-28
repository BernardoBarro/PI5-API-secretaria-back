package br.com.rotaract.secretaria.dto;
import javax.validation.constraints.Size;

public class CargoDto {

	@Size(max = 2000, message = "A Descrição deve ter no máximo 2000 caracteres")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
