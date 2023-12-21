package com.deepak.kamboj.MoneyManager.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.security.SignatureException;

@RestControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleJwtExceptions(AuthenticationException e) {
        // Handle JWT-related exceptions here
        System.out.println("YYYYY");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<String> handleAuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException e) {
        // Handle cases where JWT token is missing
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is missing");
    }

    // Add more exception handlers for other JWT-related errors as needed
}







