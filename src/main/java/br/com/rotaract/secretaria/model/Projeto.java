package br.com.rotaract.secretaria.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rotaract.secretaria.constant.AreaEnfoque;
import br.com.rotaract.secretaria.constant.Categoria;
import br.com.rotaract.secretaria.constant.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projeto")
@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_projeto")
	private Long id;

	@Column(name = "nome_projeto")
	private String nome;

	@Column(name = "descricao_projeto")
	private String descricao;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "data_fim")
	private LocalDate dataFim;

	@Column(name = "categoria")
	private Categoria categoria;

	@Column(name = "area_enfoque")
	private AreaEnfoque areaEnfoque;

	@Column(name = "status_projeto")
	private StatusProjeto status;

	@OneToMany
	@JoinColumn(name = "id_patrocinador")
	private List<Patrocinador> patrocinadores;

	@ManyToMany
	@JoinTable(name = "projeto_instituicoes_beneficiadas", joinColumns = @JoinColumn(name = "id_projeto", referencedColumnName = "id_projeto"), inverseJoinColumns = @JoinColumn(name = "id_instituicao", referencedColumnName = "id_instituicao"))
	private List<Instituicao> instituicoes;

	@ManyToMany
	@JoinTable(name = "projeto_associado", joinColumns = @JoinColumn(name = "id_projeto", referencedColumnName = "id_projeto"), inverseJoinColumns = @JoinColumn(name = "id_associado", referencedColumnName = "id_associado"))
	private List<Associado> associado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
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

	public List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(List<Patrocinador> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}

	public List<Associado> getAssociado() {
		return associado;
	}

	public void setAssociado(List<Associado> associado) {
		this.associado = associado;
	}

}
