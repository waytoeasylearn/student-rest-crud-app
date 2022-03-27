package com.student.app.exception;

import org.springframework.stereotype.Component;

/**
 * 
 * @author ashok.mariyala
 *
 */
@Component
public class StudentNotfoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StudentNotfoundException() {
		super();
	}

	public StudentNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotfoundException(String message) {
		super(message);
	}

	public StudentNotfoundException(Throwable cause) {
		super(cause);
	}
}
