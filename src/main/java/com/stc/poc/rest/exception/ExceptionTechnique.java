package com.stc.poc.rest.exception;

import java.io.Serializable;

public class ExceptionTechnique extends BaseException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3923175408558259726L;
	
	public ExceptionTechnique(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionTechnique(Throwable cause) {
		super(cause);
	}
	
	public ExceptionTechnique(String message) {
		super(message);
	}

}
