package com.jmorla.microservice.common.exceptions;

public class InvalidEmployeeException extends MicroServiceException{

	public InvalidEmployeeException() {
		super();
		
	}

	public InvalidEmployeeException(String message) {
		super(message);
	}

	
}
