package com.sap.web.entity;

public class BookingResponse {
	private String message;

	public BookingResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
