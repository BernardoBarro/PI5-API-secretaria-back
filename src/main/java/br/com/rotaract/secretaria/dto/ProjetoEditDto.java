package br.com.rotaract.secretaria.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.rotaract.secretaria.constant.AreaEnfoque;
import br.com.rotaract.secretaria.constant.Categoria;
import br.com.rotaract.secretaria.constant.StatusProjeto;
import br.com.rotaract.secretaria.model.Associado;
import br.com.rotaract.secretaria.model.Instituicao;
import br.com.rotaract.secretaria.model.Patrocinador;

public class ProjetoEditDto {

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
	@Size(max = 25, message = "O campo status deve ter no máximo 25 caracteres")
	private StatusProjeto status;
	
	@NotNull
	private LocalDateTime dataInicio;
	
	@NotNull
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
