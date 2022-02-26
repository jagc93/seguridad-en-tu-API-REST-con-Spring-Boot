package com.openwebinars.rest.error.exceptions;

public class ProductoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4607170879668092577L;

	public ProductoNotFoundException(Long id) {
		super("No se puede encontrar el producto con la ID: " + id);
	}

	public ProductoNotFoundException() {
		super("No se pueden encontrar productos");
	}

}
