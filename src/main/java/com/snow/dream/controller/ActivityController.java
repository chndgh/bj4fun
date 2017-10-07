package com.snow.dream.controller;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.Const;
import com.snow.dream.utils.ResponseCode;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by dghcch on 2017/9/27.
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;


    @PostMapping("/create")
    @ResponseBody
    public ServerResponse createActivity(HttpSession session, @RequestBody ActivityItem activityItem){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return activityService.createActivity(activityItem,user);
    }


    @GetMapping("/{status}/status")
    @ResponseBody
    public ServerResponse getStatusActivity(HttpSession session,@PathVariable Integer status){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return activityService.getActivityByStatusAndVoter(status,user.getSubOpenId());
    }

    @GetMapping("/own")
    @ResponseBody
    public ServerResponse getOwnActivity(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return activityService.getOwnActivity(user);
    }

    @GetMapping("test")
    public ServerResponse test(){
        return ServerResponse.createBySuccess("hello");
    }
}
