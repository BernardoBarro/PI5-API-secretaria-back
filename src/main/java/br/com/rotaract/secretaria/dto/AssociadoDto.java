package br.com.rotaract.secretaria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssociadoDto {

	private Long RI;

	@NotNull
	private String nome;

	@NotNull
	@Size(min = 1, max = 1)
	private String genero;

	@NotNull
	@Size(max = 25, message = "O campo ocupação deve ter no máximo 25 caracteres")
	private String ocupacao;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate nascimento;

	@NotNull
	private String cep;

	@NotNull
	@Email(message = "O e-mail deve ser válido")
	private String email;

	@NotNull
	@Size(max = 25, message = "O campo senha deve ter no máximo 25 caracteres")
	private String senha;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate admissao;

	@NotNull
	@Size(min = 11, max = 11)
	private String telefone;

	@NotNull
	@Size(max = 50, message = "O campo padrinho deve ter no máximo 50 caracteres")
	private String padrinho;

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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDate admissao) {
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

}
