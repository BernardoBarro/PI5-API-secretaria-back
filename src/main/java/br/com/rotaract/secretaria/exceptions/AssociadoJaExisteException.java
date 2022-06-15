package br.com.rotaract.secretaria.exceptions;

public class AssociadoJaExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;

	public AssociadoJaExisteException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
