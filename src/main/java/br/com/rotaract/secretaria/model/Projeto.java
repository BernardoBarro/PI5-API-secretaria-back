package br.com.rotaract.secretaria.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.rotaract.secretaria.constant.AreaEnfoque;
import br.com.rotaract.secretaria.constant.Categoria;
import br.com.rotaract.secretaria.constant.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROJETO")
@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROJETO")
	private Long id;

	@Column(name = "NOME_PROJETO")
	private String nome;

	@Column(name = "DESCRICAO_PROJETO")
	private String descricao;

	@Column(name = "DATA_INICIO")
	private LocalDateTime dataInicio;

	@Column(name = "DATA_FIM")
	private LocalDateTime dataFim;

	@Column(name = "CATEGORIA")
	private Categoria categoria;

	@Column(name = "AREA_ENFOQUE")
	private AreaEnfoque areaEnfoque;

	@Column(name = "STATUS_PROJETO")
	private StatusProjeto status;

	@OneToMany
	@JoinColumn(name = "ID_PATROCINADOR")
	private List<Patrocinador> patrocinadores;

	@ManyToMany
	@JoinColumn(name = "ID_INSTITUICAO")
	private List<Instituicao> instituicoes;

	@ManyToMany
	@Column(name = "ID_ASSOCIADO")
	private List<Associado> associados;

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

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
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

	public List<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

//	@OneToOne
//	@JoinColumn(name = "ID_CONVIDADO", nullable = false)
//	private List<Convidado> convidados;
//
//	@JsonIgnore
//	@OneToOne(mappedBy = "PROJETO")
//	private List<Reuniao> reunioes;

}
