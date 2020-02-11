package com.pozoriche.controller;

import com.pozoriche.dto.AuthenticationResponse;
import com.pozoriche.dto.LoginRequest;
import com.pozoriche.dto.RegisterRequest;
import com.pozoriche.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//spring.jpa.hibernate.ddl-auto=create
        //spring.jpa.show-sql=true

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
