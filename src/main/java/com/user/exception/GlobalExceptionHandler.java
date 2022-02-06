package com.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(ex.getMessage());
        response.setHttpstatusCode(HttpStatus.NOT_FOUND.toString());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExists ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(ex.getMessage());
        response.setHttpstatusCode(HttpStatus.CONFLICT.toString());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customException(CustomException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("BAD_REQUEST");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setHttpstatusCode(HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException ex) {
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("UNAUTHORIZED");
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setHttpstatusCode(HttpStatus.UNAUTHORIZED.toString());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> inputValidationException(Exception ex) {
    	 ExceptionResponse response=new ExceptionResponse();
         response.setErrorCode("BAD_REQUEST");
         response.setErrorMessage(ex.getMessage());
         response.setTimestamp(LocalDateTime.now());
         response.setHttpstatusCode(HttpStatus.BAD_REQUEST.toString());
         return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    	
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException ex) {
    	 ExceptionResponse response=new ExceptionResponse();
         response.setErrorCode("INTERNAL_SERVER_ERROR");
         response.setErrorMessage(ex.getMessage());
         response.setTimestamp(LocalDateTime.now());
         response.setHttpstatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
         return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }

}
