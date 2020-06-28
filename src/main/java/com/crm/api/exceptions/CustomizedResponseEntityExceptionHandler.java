package com.crm.api.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crm.api.domain.ErrorResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse("Validation Failed", HttpStatus.BAD_REQUEST, ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(RecordNotFoundException ex, WebRequest request) {
		ErrorResponse exceptionResponse = new ErrorResponse("Record Not Found", HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	 

}
