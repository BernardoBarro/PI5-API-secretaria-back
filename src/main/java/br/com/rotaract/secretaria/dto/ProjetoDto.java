package br.com.rotaract.secretaria.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjetoDto {

	@NotNull
	@Size(max = 50, message = "O campo nome deve ter no máximo 50 caracteres")
	private String nome;

	@NotNull
	@Size(max = 5000, message = "O campo descrição deve ter no máximo 5000 caracteres")
	private String descricao;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataInicio;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

}
