package com.deepak.kamboj.MoneyManager.controllers;

import com.deepak.kamboj.MoneyManager.security.AuthRequest;
import com.deepak.kamboj.MoneyManager.security.AuthResponse;
import com.deepak.kamboj.MoneyManager.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

//    @PostMapping("/register")
//    public ResponseEntity<AuthResponse> register(
//            @RequestBody RegisterReq request
//    ) throws MasterException {
//        return ResponseEntity.ok(service.register(request));
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) throws Exception {
        System.out.println("Yoo!");
        System.out.println(ResponseEntity.ok(authenticationService.authenticate(request)));
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
