package com.example.mycode.service.impl;

import com.example.mycode.enums.ResultEnum;
import com.example.mycode.exception.MyException;
import com.example.mycode.model.User;
import com.example.mycode.repository.UserRepository;
import com.example.mycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new MyException(ResultEnum.USER_NOT_FOUND));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new MyException(ResultEnum.USER_NOT_FOUND));
    }

    @Override
    public User update(User user) {
        User oldUser = findByEmail(user.getEmail());
        if (!StringUtils.isEmpty(user.getPassword())) {
            oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        oldUser.setName(user.getName());
        oldUser.setPhone(user.getPhone());
        oldUser.setAddress(user.getAddress());
        return userRepository.save(oldUser);
    }
}
