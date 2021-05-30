package com.Arriendo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Arriendo.entity.ErrorResponce;

// global exception handler
@ControllerAdvice
public class GlobalExceptionHandler {

	// exception handler for HostingNotFoundException	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleHostingNotFoundException(HostingNotFoundException exception) {
		
		// create custome error responce
		ErrorResponce errorResponce = new ErrorResponce();
		errorResponce.setMessage(exception.getMessage());
		errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponce.setTimeStamp(System.currentTimeMillis());
		
		// return responseEntity
		return new ResponseEntity<ErrorResponce>(errorResponce, HttpStatus.NOT_FOUND);
	}

	// exception handler for  MyBookingNotFoundException	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleMyBookingNotFoundException(MyBookingNotFoundException exception) {
		// create custome error responce
		ErrorResponce errorResponce = new ErrorResponce();
		errorResponce.setMessage(exception.getMessage());
		errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponce.setTimeStamp(System.currentTimeMillis());
		
		// return responseEntity
		return new ResponseEntity<ErrorResponce>(errorResponce, HttpStatus.NOT_FOUND);
	}

	// exception handler for  HostingLocationNotFoundException	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleHostingLocationNotFoundException(HostingLocationNotFoundException exception) {
		// create custome error responce
		ErrorResponce errorResponce = new ErrorResponce();
		errorResponce.setMessage(exception.getMessage());
		errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponce.setTimeStamp(System.currentTimeMillis());
		
		// return responseEntity
		return new ResponseEntity<ErrorResponce>(errorResponce, HttpStatus.NOT_FOUND);
	}

	// exception handler for  MyHostingClientNotFoundException	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleMyHostingClientNotFoundException(MyHostingClientNotFoundException exception) {
		// create custome error responce
		ErrorResponce errorResponce = new ErrorResponce();
		errorResponce.setMessage(exception.getMessage());
		errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponce.setTimeStamp(System.currentTimeMillis());
		
		// return responseEntity
		return new ResponseEntity<ErrorResponce>(errorResponce, HttpStatus.NOT_FOUND);
	}

	
	// add an exception handler for any other exception	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleAnyOtherException(Exception exception) {
		
		// create custom error response
		ErrorResponce error = new ErrorResponce();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<ErrorResponce>(error, HttpStatus.BAD_REQUEST);
	}

}
