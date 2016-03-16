package com.thoughtworks.controller;

import com.thoughtworks.model.User;
import com.thoughtworks.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userController.userService = userService;
    }

    @Test
    public void shoudReturnLoginPage() throws Exception {
        //Given

        //When
        String loginPage = userController.loginPage();

        //Then
        assertEquals(loginPage, "login");
    }

    @Test
    public void shouldLoginErrorWhenUserNameOrPassWordIsNotRight() throws Exception {
        //Given
        User user = new User();
        user.setUsername("username");
        user.setPassword("right");

        when(userService.validateUser(user)).thenReturn(false);

        //When
        String login = userController.login(user);

        //Then
        assertEquals("login", login);

    }

    @Test
    public void shouldLoginSuccessWhenUserNameOrPassWordIsRight() throws Exception {
        //Given
        User user = new User();
        user.setUsername("username")
                .setPassword("password");

        when(userService.validateUser(user)).thenReturn(true);

        //When
        String login = userController.login(user);

        //Then
        assertEquals("index", login);
    }
}