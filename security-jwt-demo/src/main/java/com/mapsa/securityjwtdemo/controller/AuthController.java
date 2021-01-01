package com.mapsa.securityjwtdemo.controller;

import com.mapsa.securityjwtdemo.domain.User;
import com.mapsa.securityjwtdemo.dto.AuthResponse;
import com.mapsa.securityjwtdemo.dto.LoginRequest;
import com.mapsa.securityjwtdemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }


    @PostMapping("/login")
    public AuthResponse authResponse(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping({"/", "/index"})
    public String sayHello() {
        return "Hello World!";
    }
}
