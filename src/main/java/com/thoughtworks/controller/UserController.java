package com.thoughtworks.controller;

import com.thoughtworks.model.User;
import com.thoughtworks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity login(@RequestBody User user) {
        boolean validateResult = userService.validateUser(user);
        Map result = new HashMap();
        if (validateResult){
            result.put("STATUS", "OK");
            return new ResponseEntity(result, HttpStatus.OK);
        }
        result.put("STATUS", "ERROR");
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
