package com.everis.cursomc.services.exceptions;

public class DataIntegrityNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public DataIntegrityNotFoundException(String msg) {
		super(msg);
	}

	public DataIntegrityNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}

}
