package com.example.mycode.service;

import com.example.mycode.dto.JwtResponse;
import com.example.mycode.dto.LoginForm;
import com.example.mycode.model.User;

public interface AuthService {

    User signup(User user);

    JwtResponse signin(LoginForm loginForm);

}
