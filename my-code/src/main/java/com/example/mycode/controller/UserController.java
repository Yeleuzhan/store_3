package com.example.mycode.controller;

import com.example.mycode.model.User;
import com.example.mycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getProfile(@PathVariable("email") String email, Principal principal) {
        if (principal.getName().equals(email)) {
            return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/profile")
    public ResponseEntity<User> update(@RequestBody User user, Principal principal) {
        try {
            if (!principal.getName().equals(user.getEmail())) {
                throw new IllegalArgumentException();
            }
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

}
