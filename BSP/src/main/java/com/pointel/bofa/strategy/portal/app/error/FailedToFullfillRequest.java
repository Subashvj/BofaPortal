package com.pointel.bofa.strategy.portal.app.error;

public class FailedToFullfillRequest extends Exception{

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


	public FailedToFullfillRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FailedToFullfillRequest(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FailedToFullfillRequest(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FailedToFullfillRequest(String message,String methodName) {
		super(message);
		this.methodName = methodName;
		// TODO Auto-generated constructor stub
	}

	public FailedToFullfillRequest(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
