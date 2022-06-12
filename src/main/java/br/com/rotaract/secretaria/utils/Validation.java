package br.com.rotaract.secretaria.utils;

import java.util.Optional;

import br.com.rotaract.secretaria.dto.AlterarSenhaDto;
import br.com.rotaract.secretaria.exceptions.AssociadoJaExisteException;
import br.com.rotaract.secretaria.exceptions.NotFoundException;
import br.com.rotaract.secretaria.exceptions.SenhaInvalida;

public final class Validation {

	public static void validReturnObject(Optional<?> opt, String message) {
		if(!opt.isPresent()) {
			throw new NotFoundException(message);
		}
	}
	
	public static void buildAssociadoExiste(Optional<?> opt, String message) {
		if(opt.isPresent()) {
			throw new AssociadoJaExisteException(message);
		}
	}

	public static void novaSenha(AlterarSenhaDto alterarSenhaDto) {
		if(!alterarSenhaDto.getNovaSenha().equals(alterarSenhaDto.getConfirmarNovaSenha())) {
			throw new SenhaInvalida("As senhas não são iguais");
		}
	}
}
