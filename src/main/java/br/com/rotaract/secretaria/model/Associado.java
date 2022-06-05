package br.com.rotaract.secretaria.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rotaract.secretaria.constant.StatusAssociado;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "associado")
@Entity
public class Associado implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_associado")
	private Long RI;

	@Column(name = "status_associado")
	private StatusAssociado status;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "data_admissao")
	private LocalDate dataAdmissao;

	@Column(name = "padrinho")
	private String padrinho;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@OneToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@OneToOne
	@JoinColumn(name = "id_cargo", nullable = false)
	private Cargo cargo;

	public Associado() {
	}
	
	public Associado(Associado associado) {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(this.cargo.getAcesso());
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

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

	public void setStatus(StatusAssociado status) {
		this.status = status;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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
