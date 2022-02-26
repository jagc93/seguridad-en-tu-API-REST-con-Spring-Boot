package com.openwebinars.rest.error.exceptions;

public class PedidoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4620070458279179044L;

	public PedidoNotFoundException() {
		super("No se han encontrado pedidos");
	}

	public PedidoNotFoundException(Long id) {
		super("No se ha encontrado ningún pedido con el ID " + id);
	}
}
