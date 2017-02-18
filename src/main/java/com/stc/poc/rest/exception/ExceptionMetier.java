package com.stc.poc.rest.exception;

import java.io.Serializable;

public class ExceptionMetier extends BaseException implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5717866463708197220L;
	
	public ExceptionMetier(String message) {
		super(message);
	}
	
	public ExceptionMetier(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionMetier(Throwable cause) {
		super(cause);
	}
	
}
