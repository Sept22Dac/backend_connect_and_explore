package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class AlreadyFullException extends RuntimeException {
	public AlreadyFullException(String msg) {
		super(msg);
	}
}
