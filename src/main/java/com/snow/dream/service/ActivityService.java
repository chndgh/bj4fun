package com.snow.dream.service;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.utils.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by dghcch on 2017/9/27.
 */
public interface ActivityService {

    ServerResponse createActivity(ActivityItem activityItem, User user);

    ServerResponse getActivityByStatusAndVoter(Integer status, String userId);

    ServerResponse getOwnActivity(User user);
}
