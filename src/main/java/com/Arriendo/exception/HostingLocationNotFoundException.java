package com.Arriendo.exception;

@SuppressWarnings("serial")
public class HostingLocationNotFoundException extends RuntimeException {
	public HostingLocationNotFoundException(String message) {
		super(message);
	}
}
