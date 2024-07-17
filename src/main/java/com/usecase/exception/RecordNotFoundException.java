package com.usecase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Error Handled Gracefully")
public class RecordNotFoundException extends Exception
{
	
	public RecordNotFoundException(String msg) {
		super(msg);
		

	}
}

