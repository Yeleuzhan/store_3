package com.example.mycode.service.impl;

import com.example.mycode.dto.JwtResponse;
import com.example.mycode.dto.LoginForm;
import com.example.mycode.enums.ResultEnum;
import com.example.mycode.exception.MyException;
import com.example.mycode.model.User;
import com.example.mycode.repository.UserRepository;
import com.example.mycode.security.JwtProvider;
import com.example.mycode.security.UserPrincipal;
import com.example.mycode.service.AuthService;
import com.example.mycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            User savedUser = userRepository.save(user);

            return userRepository.save(savedUser);
        } catch (Exception exception) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }
    }

    @Override
    public JwtResponse signin(LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.createToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = userService.findById(userPrincipal.getId());
        return new JwtResponse(
                jwt,
                user.getEmail(),
                user.getName(),
                user.getRole()
        );
    }
}
