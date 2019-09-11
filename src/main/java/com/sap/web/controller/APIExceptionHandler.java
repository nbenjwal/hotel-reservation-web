package com.sap.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sap.web.entity.APIException;
import com.sap.web.entity.APIExceptionResponse;

@ControllerAdvice
public class APIExceptionHandler {
	@ExceptionHandler(APIException.class)
	public final ResponseEntity<APIExceptionResponse> handleUserNotFoundException(APIException ex) {
		APIExceptionResponse response = new APIExceptionResponse(ex.getLocalizedMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
