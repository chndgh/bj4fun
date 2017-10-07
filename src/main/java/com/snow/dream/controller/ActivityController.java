package com.snow.dream.controller;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by dghcch on 2017/9/27.
 */
@RestController
@RequestMapping("/activity/")
public class ActivityController {
    @Autowired
    ActivityService activityService;


    @PostMapping("create")
    @ResponseBody
    public ServerResponse createActivity(@RequestBody ActivityItem activityItem, HttpSession session){
        System.out.println(activityItem.getTitle());
        if (activityItem.getStartTime()==null){
            return ServerResponse.createByErrorMessage("请输入活动开始时间");
        }else if (activityItem.getCategory()==null){
            return ServerResponse.createByErrorMessage("请输入活动类别");
        }
        return activityService.createActivity(activityItem,session);
    }


    @GetMapping("test")
    public ServerResponse test(){
        return ServerResponse.createBySuccess("hello");
    }
}
