package com.Arriendo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Arriendo.entity.HostingErrorResponce;

// global exception handler
@ControllerAdvice
public class HostingExceptionHandler {

	// exception handler for HostingNotFoundException	
	@ExceptionHandler
	public ResponseEntity<HostingErrorResponce> handleHostingNotFoundException(HostingNotFoundException exception) {
		
		// create custome error responce
		HostingErrorResponce errorResponce = new HostingErrorResponce();
		errorResponce.setMessage(exception.getMessage());
		errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponce.setTimeStamp(System.currentTimeMillis());
		
		// return responseEntity
		return new ResponseEntity<HostingErrorResponce>(errorResponce, HttpStatus.NOT_FOUND);
	}

	// add an exception handler for any other exception	
	@ExceptionHandler
	public ResponseEntity<HostingErrorResponce> handleAnyOtherException(Exception exception) {
		
		// create custom error response
		HostingErrorResponce error = new HostingErrorResponce();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<HostingErrorResponce>(error, HttpStatus.BAD_REQUEST);
	}

}
