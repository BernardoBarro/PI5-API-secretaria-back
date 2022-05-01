package br.com.rotaract.secretaria.dto;

import java.time.LocalDateTime;

public class AssociadoDto {

	private Long RI;
	private String nome;
	private LocalDateTime admissao;
	private LocalDateTime nascimento;
	private String telefone;
	private String email;
	private String cpf;
	private String ocupacao;
	private String cep;
	private String padrinho;
	private String restricaoMedica;
	private CargoDto cargo;

	public Long getRI() {
		return RI;
	}

	public void setRI(Long rI) {
		RI = rI;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDateTime admissao) {
		this.admissao = admissao;
	}

	public LocalDateTime getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDateTime nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPadrinho() {
		return padrinho;
	}

	public void setPadrinho(String padrinho) {
		this.padrinho = padrinho;
	}

	public String getRestricaoMedica() {
		return restricaoMedica;
	}

	public void setRestricaoMedica(String restricaoMedica) {
		this.restricaoMedica = restricaoMedica;
	}

	public CargoDto getCargo() {
		return cargo;
	}

	public void setCargo(CargoDto cargo) {
		this.cargo = cargo;
	}

}
