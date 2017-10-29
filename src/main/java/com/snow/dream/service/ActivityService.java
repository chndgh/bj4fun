package com.snow.dream.service;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.utils.ServerResponse;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
public interface ActivityService {

    ServerResponse createActivity(ActivityItem activityItem, User user);

    ServerResponse getActivityByStatusAndVoter(List<Integer> status, String userId,String sortField);

    ServerResponse getActivityByStatusAndVoterAndCategory(List<Integer> status, String userId,int category,String sortField);

    ServerResponse getOwnActivity(User user,String sortField);

    ServerResponse getOwnActivityByCategory(User user,Integer category,String sortField);

    ServerResponse getAvailableActivity(User user,String sortField);

    ServerResponse getAvailableCategoryActivity(User user,Integer category,String sortField);

    ServerResponse getActivityById(String id);

    ServerResponse deleteActivityById(User user,String id);

    ServerResponse voteOnActivity(String userId,String activityId);
}
