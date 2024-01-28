package com.deepak.kamboj.MoneyManager.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.security.SignatureException;

@ControllerAdvice
public class JwtExceptionHandler{

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<?> handleJwtExceptions(AuthenticationException e) {
        // Handle JWT-related exceptions here
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<?> handleAuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException e) {
        // Handle cases where JWT token is missing
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is missing");
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomExceptions(AuthenticationException e) {
        // Handle JWT-related exceptions here
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptions(AuthenticationException e) {
        // Handle JWT-related exceptions here
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

    // Add more exception handlers for other JWT-related errors as needed
}







