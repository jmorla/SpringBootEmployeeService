package com.jmorla.microservice.common.exceptions;

public class MicroServiceException extends Exception{

	
	public MicroServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MicroServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
