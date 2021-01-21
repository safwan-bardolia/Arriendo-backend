package com.Arriendo.exception;

@SuppressWarnings("serial")
public class HostingNotFoundException extends RuntimeException {
	public HostingNotFoundException(String message) {
		super(message);
	}
}
