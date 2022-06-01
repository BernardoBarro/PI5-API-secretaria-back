package br.com.rotaract.secretaria.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rotaract.secretaria.constant.StatusAssociado;
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

	@Column(name = "status_associado")
	private StatusAssociado status;

	@Column(name = "data_admissao")
	private LocalDateTime dataAdmissao;

	@Column(name = "padrinho")
	private String padrinho;

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

	public StatusAssociado getStatus() {
		return status;
	}

	public void setStatus(StatusAssociado ativo) {
		this.status = ativo;
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
