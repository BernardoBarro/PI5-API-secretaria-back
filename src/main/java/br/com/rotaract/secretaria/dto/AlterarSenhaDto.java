package br.com.rotaract.secretaria.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AlterarSenhaDto {

	private String senhaAtual;
	private String novaSenha;
	private String confirmarNovaSenha;

	public String getSenhaAtual() {
		return new BCryptPasswordEncoder().encode(this.senhaAtual);
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public String getConfirmarNovaSenha() {
		return confirmarNovaSenha;
	}

}
