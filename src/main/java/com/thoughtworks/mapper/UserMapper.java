package com.thoughtworks.mapper;

import com.thoughtworks.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert(
            "insert into users(username, password) values(#{username}, #{password})"
    )
    Integer insert(User user);


    @Select(
            "select * from users where username=#{username}"
    )
    User findUserByName(String username);
}
