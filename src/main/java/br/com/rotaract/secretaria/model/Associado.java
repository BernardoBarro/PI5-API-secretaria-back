package br.com.rotaract.secretaria.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rotaract.secretaria.constant.StatusAssociado;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ASSOCIADO")
@Entity
public class Associado implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ASSOCIADO")
	private Long RI;

	@Column(name = "STATUS_ASSOCIADO")
	private StatusAssociado status;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "DATA_ADMISSAO")
	private LocalDate admissao;

	@Column(name = "PADRINHO")
	private String padrinho;

	@Column(name = "EMAIL")
	private String email;

	@JsonIgnore
	@Column(name = "SENHA")
	private String senha;

	@OneToOne
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinTable(name = "ASSOCIADO_CARGO", 
		joinColumns = @JoinColumn(name = "ID_ASSOCIADO", referencedColumnName = "ID_ASSOCIADO"), 
		inverseJoinColumns = @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO"))
	private Cargo cargo;

	public Associado() {
	}

	public Associado(Associado associado) {
		this.RI = associado.getRI();
		this.status = associado.getStatus();
		this.admissao = associado.getAdmissao();
		this.padrinho = associado.getPadrinho();
		this.email = associado.getEmail();
		this.senha = associado.getSenha();
		this.pessoa = associado.getPessoa();
		this.cargo = associado.getCargo();
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(this.cargo.getAcesso());
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return this.senha;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return this.email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

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

	public LocalDate getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDate admissao) {
		this.admissao = admissao;
	}

	public String getPadrinho() {
		return padrinho;
	}

	public void setPadrinho(String padrinho) {
		this.padrinho = padrinho;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
