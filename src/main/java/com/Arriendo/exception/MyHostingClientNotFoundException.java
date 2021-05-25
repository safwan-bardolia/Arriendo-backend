package com.Arriendo.exception;

@SuppressWarnings("serial")
public class MyHostingClientNotFoundException extends RuntimeException {
	public MyHostingClientNotFoundException(String msg) {
		super(msg);
	}
}
