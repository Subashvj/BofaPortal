package com.pointel.bofa.strategy.portal.app.pagination;

public class PagingResponse {
	
	private boolean success;
	private String message;
	private Payload payload;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	@Override
	public String toString() {
		return "PagingResponse [success=" + success + ", message=" + message + ", payload=" + payload + "]";
	}
	
	
	

}
