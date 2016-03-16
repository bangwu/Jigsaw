package com.thoughtworks.service;

import com.thoughtworks.mapper.UserMapper;
import com.thoughtworks.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService.userMapper = userMapper;

    }

    @Test
    public void shouldSaveTheUser() throws Exception {
        User user = new User();
        when(userMapper.insert(user)).thenReturn(1);

        Integer save = userService.save(user);

        assertEquals(new Integer(1), save);
    }

    @Test
    public void shouldValidateUserFailer() throws Exception {
        String username = "username";
        String password = "password";
        User user = new User();
        user.setUsername(username)
                .setPassword(password);

        User exitUser = new User();
        exitUser.setUsername(username)
                .setPassword("pass");

        when(userMapper.findUserByName(username)).thenReturn(exitUser);

        assertFalse(userService.validateUser(user));
    }

    @Test
    public void shouldValidateUserSuccess() throws Exception {
        String username = "username";
        String password = "password";
        User user = new User();
        user.setUsername(username)
                .setPassword(password);

        User exitUser = new User();
        exitUser.setUsername(username)
                .setPassword(password);

        when(userMapper.findUserByName(username)).thenReturn(exitUser);

        assertTrue(userService.validateUser(user));
    }
}