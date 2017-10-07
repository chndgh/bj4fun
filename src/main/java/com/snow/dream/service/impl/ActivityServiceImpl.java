package com.snow.dream.service.impl;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.repository.ActivityItemRepository;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.ActivityStatus;
import com.snow.dream.utils.Const;
import com.snow.dream.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by dghcch on 2017/9/27.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityItemRepository activityItemRepository;

    @Override
    public ServerResponse createActivity(ActivityItem activityItem, HttpSession session) {
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        activityItem.setStatus(ActivityStatus.CREATED.getValue());
        activityItem.setOwnerUserId(currentUser.getSubOpenId());
        ActivityItem item  = activityItemRepository.save(activityItem);
        if (item != null){
            return ServerResponse.createBySuccess(item);
        }
        return ServerResponse.createByErrorMessage("创建活动失败");
    }

    public ServerResponse getActivityItemByCategory(String category) {
                return null;
    }
}
