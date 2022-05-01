package br.com.rotaract.secretaria.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "associado")
@Entity
public class Associado {

	@Id
	@Column(name = "id_associado")
	private Long RI;

	@Column(name = "data_admissao")
	private LocalDateTime dataAdmissao;

	@Column(name = "padrinho")
	private String padrinho;

	@Column(name = "historico")
	private String historico;

	@Column(name = "restricao_medica")
	private String restricaoMedica;

	@Column(name = "conselho_diretor")
	private boolean conselhoDiretor;

	@OneToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@OneToOne
	@JoinColumn(name = "id_cargo", nullable = false)
	private Cargo cargo;

	public Long getRI() {
		return RI;
	}

	public void setRI(Long rI) {
		RI = rI;
	}

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getPadrinho() {
		return padrinho;
	}

	public void setPadrinho(String padrinho) {
		this.padrinho = padrinho;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getRestricaoMedica() {
		return restricaoMedica;
	}

	public void setRestricaoMedica(String restricaoMedica) {
		this.restricaoMedica = restricaoMedica;
	}

	public boolean isConselhoDiretor() {
		return conselhoDiretor;
	}

	public void setConselhoDiretor(boolean conselhoDiretor) {
		this.conselhoDiretor = conselhoDiretor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
