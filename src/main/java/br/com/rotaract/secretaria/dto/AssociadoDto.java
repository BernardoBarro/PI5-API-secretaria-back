package br.com.rotaract.secretaria.dto;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AssociadoDto {

	private Long RI;
	
	@NotBlank
	private String nome;
	
	@Size(min = 1, max = 1)
	private String genero;
	
	@Size(max = 25, message = "O campo ocupação deve ter no máximo 25 caracteres")
	private String ocupacao;
	
	@NotBlank
	private LocalDateTime nascimento;
	
	@NotBlank
	private String cep;
	
	@Email(message = "O e-mail deve ser válido")
	private String email;
	
	@NotBlank
	@Size(max = 25, message = "O campo senha deve ter no máximo 25 caracteres")
	private String senha;
	
	@NotBlank
	private LocalDateTime admissao;
	
	@Size(min = 11, max = 11)
	private String telefone;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

}
