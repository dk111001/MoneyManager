package com.deepak.kamboj.MoneyManager.exception;
import java.io.IOException;
import java.util.Map;

import com.deepak.kamboj.MoneyManager.model.ErrorResponse;
import com.deepak.kamboj.MoneyManager.model.RequestResponse;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<?> handleJwtExceptions(AuthenticationException e) {
        // Handle JWT-related exceptions here
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException ex) {
        RequestResponse requestResponse = RequestResponse.builder().status(401).data("").message("Bad Credentials").build();
        return new ResponseEntity<>(requestResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnhandledException(Exception ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token is invalid or has expired");
    }

}
