package com.deepak.kamboj.MoneyManager.controllers;

import com.deepak.kamboj.MoneyManager.model.RequestResponse;
import com.deepak.kamboj.MoneyManager.model.User;
import com.deepak.kamboj.MoneyManager.security_old.AuthRequest;
import com.deepak.kamboj.MoneyManager.security_old.AuthResponse;
import com.deepak.kamboj.MoneyManager.security_old.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RequestResponse> register(
            @RequestBody User request
    ) throws Exception {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/user")
    public String getUser(){
        return "user";
    }
}
