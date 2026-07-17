package com.entry.entrydsmapi.global.exception;

import com.entry.entrydsmapi.domain.user.exception.InvalidCredentialsException;
import com.entry.entrydsmapi.domain.user.exception.PhoneAlreadyExistsException;
import com.entry.entrydsmapi.domain.user.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> HandleInvalidCredentials(InvalidCredentialsException e){

        ErrorResponse response = ErrorResponse.builder()
                .code("INVALID_CREDENTIALS")
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler(PhoneAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> HandlePhoneAlreadyExists(PhoneAlreadyExistsException e){

        ErrorResponse response = ErrorResponse.builder()
                .code("PHONE_ALREADY_EXISTS")
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> HandlerMethodArgumentNotValid(MethodArgumentNotValidException e){
        ErrorResponse response = ErrorResponse.builder()
                .code("INVALID_INPUT")
                .message(e.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage())
                .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> HandlerUserNotFound(UserNotFoundException e){
        ErrorResponse response = ErrorResponse.builder()
                .code("USER_NOT_FOUND")
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
