package br.com.rotaract.secretaria.exceptions;

public class UnauthorizedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private String msg;

	public UnauthorizedException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
