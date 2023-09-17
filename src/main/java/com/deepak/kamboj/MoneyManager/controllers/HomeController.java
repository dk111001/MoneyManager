package com.deepak.kamboj.MoneyManager.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/status")
    @PreAuthorize("hasAuthority('Status')")
    public String status(){
        return "welcome status";
    }

    @GetMapping("/user")
    public String user(){
        return "welcome user";
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }


}
