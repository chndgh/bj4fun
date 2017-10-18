package com.snow.dream.controller;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.repository.UserRepository;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by dghcch on 2017/9/27.
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    @ResponseBody
    public ServerResponse createActivity(@RequestHeader("userId") String userId,@RequestBody ActivityItem activityItem){
        User user= userRepository.findOne(userId);
        if (user==null){
            return ServerResponse.createByErrorMessage("非法请求，请重新登陆");
        }
        return activityService.createActivity(activityItem,user);
    }


    @PostMapping("/status")
    @ResponseBody
    public ServerResponse getActivityByStatus(@RequestHeader("userId") String userId, @RequestBody List<Integer> status){
        User user= userRepository.findOne(userId);
        if (user==null){
            return ServerResponse.createByErrorMessage("非法请求，请重新登陆");
        }
        return activityService.getActivityByStatusAndVoter(status,user.getSubOpenId());
    }


    @GetMapping("/available")
    @ResponseBody
    public ServerResponse getAvailableActivity(@RequestHeader("userId") String userId){
        User user= userRepository.findOne(userId);
        if (user==null){
            return ServerResponse.createByErrorMessage("非法请求，请重新登陆");
        }
        return activityService.getAvailableActivity(user);
    }



    @GetMapping("/own")
    @ResponseBody
    public ServerResponse getOwnActivity(@RequestHeader("userId") String userId){
        User user= userRepository.findOne(userId);
        if (user==null){
            return ServerResponse.createByErrorMessage("非法请求，请重新登陆");
        }
        return activityService.getOwnActivity(user);
    }

    @GetMapping("/{id}/detail")
    public ServerResponse getActivityDetail(@RequestHeader("userId") String userId, @PathVariable String id){
        User user= userRepository.findOne(userId);
        if (user==null){
            return ServerResponse.createByErrorMessage("非法请求，请重新登陆");
        }
        return activityService.getActivityById(id);
    }

    @PostMapping("/vote")
    public ServerResponse voteOnActivity(@RequestHeader("userId") String userId,@RequestBody String activityId){
        User user= userRepository.findOne(userId);
        if (user==null){
            return ServerResponse.createByErrorMessage("非法请求，请重新登陆");
        }
        return activityService.voteOnActivity(userId, activityId);
    }


    @GetMapping("test")
    public ServerResponse test(){
        return ServerResponse.createBySuccess("hello");
    }
}
