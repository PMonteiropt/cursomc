package com.pedro.cursomc.services.exceptions;

public class ObjectNotFoundEception extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundEception(String msg) {
		super(msg);
	}

	public ObjectNotFoundEception(String msg, Throwable cause) {
		super(msg,cause);
	}

}
