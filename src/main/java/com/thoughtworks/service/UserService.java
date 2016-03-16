package com.thoughtworks.service;

import com.thoughtworks.mapper.UserMapper;
import com.thoughtworks.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    UserMapper userMapper;

    public User save(User user) {
        return null;
    }
}
