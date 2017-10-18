package com.snow.dream.service.impl;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.repository.ActivityItemRepository;
import com.snow.dream.repository.UserRepository;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.ActivityStatus;
import com.snow.dream.utils.Const;
import com.snow.dream.utils.ResponseCode;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dghcch on 2017/9/27.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityItemRepository activityItemRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ServerResponse createActivity(ActivityItem activityItem, User user) {
            activityItem.setId(UUID.randomUUID().toString().substring(0,7));
            activityItem.setCreateTime(new Date().getTime());
            activityItem.setStatus(ActivityStatus.CREATED.getCode());
            activityItem.setOwnerUser(user);
            ActivityItem item  = activityItemRepository.save(activityItem);
            if (item != null){
                return ServerResponse.createBySuccess(item);
            }
            return ServerResponse.createByErrorMessage("创建活动失败");

    }


    public ServerResponse getAvailableActivity(User user) {
        List<ActivityItem> activityItems = activityItemRepository.findAvailableActivities(user.getSubOpenId(), Arrays.asList(1001,1002,1003));
        if (activityItems!=null){
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有可以参加的活动");
    }

    public ServerResponse getActivityByStatusAndVoter(List<Integer> status, String userId){
        List<ActivityItem> activityItems = activityItemRepository.findByStatusInAndVoters(status,userId);
        if (activityItems!=null){
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有活动。");
    }

    public ServerResponse getOwnActivity(User user){
        List<ActivityItem> activityItems = activityItemRepository.findByOwnerUserId(user.getSubOpenId());
        if (activityItems!=null){
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有创建活动。");
    }

    public ServerResponse getActivityById(String id){
        ActivityItem activityItem = activityItemRepository.findById(id);
        if (activityItem != null){
            return ServerResponse.createBySuccess(activityItem);
        }
        return ServerResponse.createByErrorMessage("未查到活动");
    }

    public ServerResponse voteOnActivity(String userId,String activityId){
        ActivityItem activityItem = activityItemRepository.findById(activityId);
        List<User> voters = activityItem.getVoters();
        User user = userRepository.findOne(userId);
        if (voters==null){
            List<User> users = new ArrayList<>();
            users.add(user);
            activityItem.setVoters(users);
            activityItem.setRealCount(1);
            ActivityItem reActivityItem = activityItemRepository.save(activityItem);
            return ServerResponse.createBySuccess("报名成功",reActivityItem);
        }else {
            if (voters.size() == activityItem.getMaxCount()){
                ServerResponse.createByErrorMessage("报名人数已满！");
            }
            for (User voter:voters){
                if (voter.getSubOpenId().equals(userId)){
                    return ServerResponse.createByErrorMessage("您已经报过名了...");
                }
            }
            activityItem.setRealCount(activityItem.getRealCount()+1);
            activityItem.getVoters().add(user);
            return ServerResponse.createBySuccess("报名成功",activityItemRepository.save(activityItem));
        }
    }

    public ServerResponse getActivityItemByCategory(String category) {
                return null;
    }
}
