package com.mcann.dumenflix.exception;

import lombok.Getter;

@Getter
public class DumenFlixApplicationException extends RuntimeException{
	private ErrorType errorType;
	public DumenFlixApplicationException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}