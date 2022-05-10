package br.com.rotaract.secretaria.dto;

import java.time.LocalDateTime;

import br.com.rotaract.secretaria.constant.StatusAssociado;

public class AssociadoEditDto {

	private String nome;
	private StatusAssociado status;
	private String genero;
	private String ocupacao;
	private LocalDateTime nascimento;
	private String cep;
	private String email;
	private LocalDateTime admissao;
	private String telefone;
	private String padrinho;
	private CargoDto cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusAssociado getStatus() {
		return status;
	}

	public void setStatus(StatusAssociado status) {
		this.status = status;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public LocalDateTime getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDateTime nascimento) {
		this.nascimento = nascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDateTime admissao) {
		this.admissao = admissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPadrinho() {
		return padrinho;
	}

	public void setPadrinho(String padrinho) {
		this.padrinho = padrinho;
	}

	public CargoDto getCargo() {
		return cargo;
	}

	public void setCargo(CargoDto cargo) {
		this.cargo = cargo;
	}

}
