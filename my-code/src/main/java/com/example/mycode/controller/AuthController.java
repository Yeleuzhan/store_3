package com.example.mycode.controller;

import com.example.mycode.dto.JwtResponse;
import com.example.mycode.dto.LoginForm;
import com.example.mycode.model.User;
import com.example.mycode.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        try {
            return new ResponseEntity<>(authService.signup(user), HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signin(@RequestBody LoginForm loginForm) {
        try {
            return new ResponseEntity<>(authService.signin(loginForm), HttpStatus.OK);
        } catch (AuthenticationException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
