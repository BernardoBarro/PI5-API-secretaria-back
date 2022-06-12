package br.com.rotaract.secretaria.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;

	public NotFoundException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
