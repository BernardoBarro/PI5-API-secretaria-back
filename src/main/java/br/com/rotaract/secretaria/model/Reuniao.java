package br.com.rotaract.secretaria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REUNIAO")
@Entity

public class Reuniao{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REUNIAO")
	private Long id;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "DATA_REUNIAO")
	private LocalDate dataReuniao;

	@Column(name = "ASSUNTO")
	private String assunto;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "LOCAL")
	private String local;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDataReuniao() {
		return dataReuniao;
	}

	public void setDataReuniao(LocalDate dataReuniao) {
		this.dataReuniao = dataReuniao;
	}
	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
    
	/*public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Convidado getConvidado() {
		return convidado;
	}

	public void setConvidado(Convidado convidado) {
		this.convidado = convidado;
	}*/

	
}


     