package com.stc.poc.rest.exception;


import java.io.Serializable;

public abstract class BaseException extends Exception implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4908426247750433987L;

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
	
	public BaseException(String message) {
		super(message);
	}
	
}
