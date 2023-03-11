package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class EventNotFoundException extends RuntimeException{
	
	public EventNotFoundException(String msg) {
		super(msg);
	}

}
