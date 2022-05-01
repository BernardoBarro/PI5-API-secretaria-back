package br.com.rotaract.secretaria.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reuniao")
@Entity
public class Reuniao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReuniao")
	private Long id;

	@Column(name = "DataReuniao")
	private LocalDateTime dataReuniao;

	@Column(name = "Assunto")
	private String assunto;

	@Column(name = "Local")
	private String local;

	@ManyToMany
	private List<Associado> associados;

	@ManyToMany
	private List<Projeto> projeto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataReuniao() {
		return dataReuniao;
	}

	public void setDataReuniao(LocalDateTime dataReuniao) {
		this.dataReuniao = dataReuniao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

	public List<Projeto> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<Projeto> projeto) {
		this.projeto = projeto;
	}

}
