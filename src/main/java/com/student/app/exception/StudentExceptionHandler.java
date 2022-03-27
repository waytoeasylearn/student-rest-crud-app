package com.student.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author ashok.mariyala
 *
 */
@ControllerAdvice
public class StudentExceptionHandler {
	@ExceptionHandler(value = StudentNotfoundException.class)
	public ResponseEntity<Object> exception(StudentNotfoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
