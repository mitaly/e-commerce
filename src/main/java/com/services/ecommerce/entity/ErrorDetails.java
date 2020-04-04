package com.services.ecommerce.entity;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private Integer statusCode;
	private String errorMessage;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(Date timestamp, Integer statusCode, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorDetails [timestamp=");
		builder.append(timestamp);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append("]");
		return builder.toString();
	}

}
