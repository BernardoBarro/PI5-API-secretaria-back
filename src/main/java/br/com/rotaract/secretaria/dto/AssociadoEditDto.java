package br.com.rotaract.secretaria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rotaract.secretaria.constant.StatusAssociado;

public class AssociadoEditDto {

	@NotNull
	private String nome;

	@NotNull
	@Size(max = 25, message = "O campo staus deve ter no máximo 25 caracteres")
	private StatusAssociado status;

	@NotNull
	@Size(min = 1, max = 1)
	private String genero;

	@NotNull
	@Size(max = 25, message = "O campo ocupação deve ter no máximo 25 caracteres")
	private String ocupacao;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate nascimento;

	@NotNull
	private String cep;

	@NotNull
	@Email(message = "O e-mail deve ser válido")
	private String email;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate admissao;

	@NotNull
	@Size(min = 11, max = 11)
	private String telefone;

	@NotNull
	@Size(max = 50, message = "O campo padrinho deve ter no máximo 50 caracteres")
	private String padrinho;

	@NotNull
	@Size(max = 2000, message = "O campo cargo deve ter no máximo 2000 caracteres")
	private String cargo;

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
