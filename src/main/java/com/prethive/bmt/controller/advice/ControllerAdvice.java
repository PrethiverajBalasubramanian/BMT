package com.prethive.bmt.controller.advice;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice 
{
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> handleRunTimeExcecption(RuntimeException e)
	{
		return ResponseEntity.internalServerError().body(Map.of("code", "INTERNAL_SERVER_ERROR","status","error"));
	}
}
