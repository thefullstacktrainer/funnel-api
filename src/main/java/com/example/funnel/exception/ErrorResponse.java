package com.example.funnel.exception;

public class ErrorResponse {
    public ErrorResponse(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	private String error;
    private String message;
    // constructors, getters, setters
}
