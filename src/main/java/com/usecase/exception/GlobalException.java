package com.usecase.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
    
    
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());
        
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        
        body.put("errors", errors);
        
        return new ResponseEntity<> (body, headers, status);
    }

	
	@ExceptionHandler(value=RecordNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(RecordNotFoundException exception, WebRequest webRequest) {

 

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTime(LocalDateTime.now());
        exceptionResponse.setMessage(exception.getMessage());


        return new ResponseEntity<Object> (exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
