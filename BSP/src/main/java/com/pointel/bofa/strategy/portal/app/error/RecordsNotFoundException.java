package com.pointel.bofa.strategy.portal.app.error;

public class RecordsNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String methodName = "";

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public RecordsNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RecordsNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RecordsNotFoundException(String message,String methodName) {
		super(message);
		this.methodName = methodName;
		// TODO Auto-generated constructor stub
	}

	public RecordsNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
