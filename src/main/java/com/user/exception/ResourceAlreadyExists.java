package com.user.exception;

public class ResourceAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExists(String message)
	{
		super(message);
	}

}
