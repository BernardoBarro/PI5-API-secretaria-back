package br.com.rotaract.secretaria.utils;

import java.util.Optional;

import br.com.rotaract.secretaria.exceptions.AssociadoJaExisteException;
import br.com.rotaract.secretaria.exceptions.NotFoundException;

public final class BuildError {

	public static void buildNotFoundException(Optional<?> opt, String message) {
		if(!opt.isPresent()) {
			throw new NotFoundException(message);
		}
	}
	
	public static void buildAssociadoExiste(Optional<?> opt, String message) {
		if(opt.isPresent()) {
			throw new AssociadoJaExisteException(message);
		}
	}
}
