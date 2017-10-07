package com.snow.dream.service;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.utils.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by dghcch on 2017/9/27.
 */
public interface ActivityService {

    ServerResponse createActivity(ActivityItem activityItem, HttpSession session);
}
