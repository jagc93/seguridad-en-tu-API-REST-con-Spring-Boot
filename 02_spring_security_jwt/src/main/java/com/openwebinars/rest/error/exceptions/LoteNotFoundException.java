package com.openwebinars.rest.error.exceptions;

public class LoteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8443561341422405282L;

	public LoteNotFoundException() {
		super("No se han encontrado lotes de productos");
	}

	public LoteNotFoundException(Long id) {
		super("No se ha encontrado ningún lote con el ID " + id);
	}
}
