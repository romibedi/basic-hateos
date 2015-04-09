package com.tutorial.core.services.exceptions;

public class AccountExistsException extends RuntimeException{

	public AccountExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountExistsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
