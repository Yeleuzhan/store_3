package com.example.mycode.service;

import com.example.mycode.model.User;

public interface UserService {

    User findById(Long id);

    User findByEmail(String email);

    User update(User user);

}
