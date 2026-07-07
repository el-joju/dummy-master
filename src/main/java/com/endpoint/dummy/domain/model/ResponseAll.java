package com.endpoint.dummy.domain.model;

public class ResponseAll {
	private String status;
	private Empleado data;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Empleado getData() {
		return data;
	}

	public void setData(Empleado data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
