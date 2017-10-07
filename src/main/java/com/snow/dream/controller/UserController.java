package com.snow.dream.controller;

import com.snow.dream.entity.User;
import com.snow.dream.service.UserService;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by edward on 17/10/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ServerResponse login(@RequestParam String code, @RequestBody User user){
        System.out.println(user);
        System.out.println(code);
        return userService.login(code);
    }
}
