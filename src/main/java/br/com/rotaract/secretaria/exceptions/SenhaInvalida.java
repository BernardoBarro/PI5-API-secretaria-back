package br.com.rotaract.secretaria.exceptions;

public class SenhaInvalida extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;

	public SenhaInvalida(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
