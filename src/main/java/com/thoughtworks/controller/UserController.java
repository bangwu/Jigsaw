package com.thoughtworks.controller;

import com.thoughtworks.model.User;
import com.thoughtworks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(HttpServletRequest request) {
        User user = new User();
        user.setPassword(request.getParameter("username"))
                .setPassword(request.getParameter("password"));
        userService.save(user);
        return "index";
    }
}
