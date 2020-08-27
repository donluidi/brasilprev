package com.br.brasilprev.application.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2724257859580344962L;

	public CustomerNotFoundException(String exception) {
		super(exception);
	}

}
