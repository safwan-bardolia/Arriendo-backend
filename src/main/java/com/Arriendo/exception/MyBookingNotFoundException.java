package com.Arriendo.exception;


@SuppressWarnings("serial")
public class MyBookingNotFoundException extends RuntimeException{
	public MyBookingNotFoundException(String msg) {
		super(msg);
	}
}
