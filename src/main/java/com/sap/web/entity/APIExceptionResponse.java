package com.sap.web.entity;

public class APIExceptionResponse {
	private String message;

	public APIExceptionResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
