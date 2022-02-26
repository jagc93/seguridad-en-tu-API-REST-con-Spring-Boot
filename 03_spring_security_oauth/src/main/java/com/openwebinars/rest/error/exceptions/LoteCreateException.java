package com.openwebinars.rest.error.exceptions;

public class LoteCreateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2430139837763266417L;

	public LoteCreateException() {
		super("Error al crear un nuevo lote");
	}
}
