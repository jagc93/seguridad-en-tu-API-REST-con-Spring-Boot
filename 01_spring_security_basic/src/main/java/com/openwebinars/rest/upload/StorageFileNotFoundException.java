package com.openwebinars.rest.upload;

public class StorageFileNotFoundException extends StorageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1190563259208276485L;

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
