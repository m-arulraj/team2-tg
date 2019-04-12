package com.virtusa.sportmanagementsystem.contestownerapi.domain;

public class ErrorResponse {
	
	private boolean isError;
	//private List<Message> messages;
	private String message;
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
