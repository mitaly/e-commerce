package com.services.ecommerce.exception;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.services.ecommerce.entity.ErrorDetails;

@ControllerAdvice
public class GlobalEcommerceExceptionHandler {

	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@ExceptionHandler(ECommerceException.class)
	public ResponseEntity<ErrorDetails> ecommerceException(ECommerceException ex){
		HttpStatus httpStatus = ex.getHttpStatusCode() == 400 ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
		String message = messageSource.getMessage(ex.geterrorMessage(), ex.getErrorArguments(), Locale.getDefault());
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getHttpStatusCode(), message);
		return new ResponseEntity<ErrorDetails>(errorDetails, httpStatus);
	}
}
