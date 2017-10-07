package com.snow.dream.controller;

import com.snow.dream.entity.User;
import com.snow.dream.service.UserService;
import com.snow.dream.utils.Const;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by edward on 17/10/5.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public ServerResponse login(HttpSession httpSession,@RequestBody User user){
        System.out.println(user);
        ServerResponse<User> response = userService.login(user);
        if (response.isSuccess()){
            httpSession.setAttribute(Const.CURRENT_USER,user);
        }
        return response;
    }
}
