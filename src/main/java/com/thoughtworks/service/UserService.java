package com.thoughtworks.service;

import com.thoughtworks.mapper.UserMapper;
import com.thoughtworks.model.User;
import com.thoughtworks.util.JigsawSqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserMapper userMapper;

    public UserService() {
        this.userMapper = JigsawSqlSessionFactory.getMapper(UserMapper.class);
    }

    public Integer save(User user) {
        return userMapper.insert(user);
    }

    public boolean validateUser(User user) {
        User exitUser = userMapper.findUserByName(user.getUsername());
        if(exitUser != null && exitUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
