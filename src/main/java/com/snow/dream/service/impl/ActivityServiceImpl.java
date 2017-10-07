package com.snow.dream.service.impl;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.repository.ActivityItemRepository;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.ActivityStatus;
import com.snow.dream.utils.Const;
import com.snow.dream.utils.ResponseCode;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityItemRepository activityItemRepository;

    @Override
    public ServerResponse createActivity(ActivityItem activityItem, User user) {
            activityItem.setStatus(ActivityStatus.CREATED.getCode());
            activityItem.setOwnerUserId(user.getSubOpenId());
            ActivityItem item  = activityItemRepository.save(activityItem);
            if (item != null){
                return ServerResponse.createBySuccess(item);
            }
            return ServerResponse.createByErrorMessage("创建活动失败");

    }

    public ServerResponse getActivityByStatusAndVoter(Integer status, String userId){
        List<ActivityItem> activityItems = activityItemRepository.findByStatusAndVoters(status,userId);
        if (activityItems!=null){
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有"+ActivityStatus.codeOf(status).getValue()+"活动。");
    }

    public ServerResponse getOwnActivity(User user){
        List<ActivityItem> activityItems = activityItemRepository.findByOwnerUserId(user.getSubOpenId());
        if (activityItems!=null){
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有创建活动。");
    }

    public ServerResponse getActivityItemByCategory(String category) {
                return null;
    }
}
