package com.thoughtworks.bootcamp.response;

public class Response {
	private String message;
	private int status;
	
	public Response(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	
	public Response() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
