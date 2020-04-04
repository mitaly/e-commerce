package com.services.ecommerce.exception;

import java.util.Arrays;

public class ECommerceException extends Exception{
	private final Integer httpStatusCode;
	private final String errorMessage;
	private final String[] errorArguments;
	
	public ECommerceException(String errorMessage) {
		this(null, errorMessage, null, null);
	}
	
	public ECommerceException(Integer httpStatusCode, String errorMessage) {
		this(httpStatusCode, errorMessage, null, null);
	}
	
	public ECommerceException(Integer httpStatusCode, String errorMessage, String[] errorArguments) {
		this(httpStatusCode, errorMessage, errorArguments, null);
	}
	
	public ECommerceException(Integer httpStatusCode, String errorMessage, String[] errorArguments, Throwable cause) {
		super(cause);
		this.httpStatusCode = httpStatusCode;
		this.errorMessage = errorMessage;
		this.errorArguments = errorArguments;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public String geterrorMessage() {
		return errorMessage;
	}

	public String[] getErrorArguments() {
		return errorArguments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ECommerceException [httpStatusCode=");
		builder.append(httpStatusCode);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append(", errorArguments=");
		builder.append(Arrays.toString(errorArguments));
		builder.append("]");
		return builder.toString();
	}
	
}
