package br.com.rotaract.secretaria.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.rotaract.secretaria.constant.AreaEnfoque;
import br.com.rotaract.secretaria.constant.Categoria;
import br.com.rotaract.secretaria.constant.StatusProjeto;
import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.model.Patrocinador;

public class ProjetoEditDto {

	private String nome;
	private String descricao;
	private Categoria categoria;
	private AreaEnfoque areaEnfoque;
	private StatusProjeto status;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFinal;
	private List<Patrocinador> patrocinadores;
	private List<Instituicao> instituicao;
	private List<Associado> associados;

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

	public StatusProjeto getStatus() {
		return status;
	}

	public void setStatus(StatusProjeto status) {
		this.status = status;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(List<Patrocinador> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	public List<Instituicao> getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(List<Instituicao> instituicao) {
		this.instituicao = instituicao;
	}

	public List<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

}
