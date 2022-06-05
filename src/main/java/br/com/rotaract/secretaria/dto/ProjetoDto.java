package br.com.rotaract.secretaria.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rotaract.secretaria.constant.AreaEnfoque;
import br.com.rotaract.secretaria.constant.Categoria;
import br.com.rotaract.secretaria.model.Instituicao;

public class ProjetoDto {

	@NotNull
	@Size(max = 50, message = "O campo nome deve ter no máximo 50 caracteres")
	private String nome;

	@NotNull
	@Size(max = 5000, message = "O campo descrição deve ter no máximo 5000 caracteres")
	private String descricao;

	@NotNull
	@Size(max = 50, message = "O campo categoria deve ter no máximo 50 caracteres")
	private Categoria categoria;

	@NotNull
	@Size(max = 50, message = "O campo área de enfoque deve ter no máximo 50 caracteres")
	private AreaEnfoque areaEnfoque;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataInicio;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataFinal;

	private List<PatrocinadorDto> patrocinadores;
	private List<Instituicao> instituicoes;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public AreaEnfoque getAreaEnfoque() {
		return areaEnfoque;
	}

	public void setAreaEnfoque(AreaEnfoque areaEnfoque) {
		this.areaEnfoque = areaEnfoque;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<PatrocinadorDto> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(List<PatrocinadorDto> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}

}
