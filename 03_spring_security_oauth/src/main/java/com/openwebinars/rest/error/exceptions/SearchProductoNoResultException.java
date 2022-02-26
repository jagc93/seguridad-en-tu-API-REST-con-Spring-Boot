package com.openwebinars.rest.error.exceptions;

public class SearchProductoNoResultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8453249578607820232L;

	public SearchProductoNoResultException() {
		super("La búsqueda de productos no produjo resultados");
	}

	public SearchProductoNoResultException(String txt) {
		super(String.format("El término de búsqueda %s no produjo resultados", txt));
	}

}
