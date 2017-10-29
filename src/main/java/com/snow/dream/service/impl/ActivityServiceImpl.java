package com.snow.dream.service.impl;

import com.snow.dream.entity.ActivityItem;
import com.snow.dream.entity.User;
import com.snow.dream.repository.ActivityItemRepository;
import com.snow.dream.repository.UserRepository;
import com.snow.dream.service.ActivityService;
import com.snow.dream.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            activityItem.setStatus(ActivityStatus.VOTING.getCode());
            activityItem.setOwnerUser(user);
            ActivityItem item  = activityItemRepository.save(activityItem);
            if (item != null){
                return ServerResponse.createBySuccess(item);
            }
            return ServerResponse.createByErrorMessage("创建活动失败!");

    }

    public ServerResponse getAvailableActivity(User user,String sortField){
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,sortField);
        List<ActivityItem> activityItems = activityItemRepository.findAvailableActivities(user.getSubOpenId(), Arrays.asList(1001,1002,1003,1004,1005),pageable);
        if (activityItems!=null){
            this.checkAndSetActivityStatus(activityItems);
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有可以参加的活动!");
    }

    public ServerResponse getAvailableCategoryActivity(User user,Integer category,String sortField){
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,sortField);
        List<ActivityItem> activityItems = activityItemRepository.findAvailableCategoryActivities(user.getSubOpenId(),
                                                                                    Arrays.asList(1001,1002,1003,1004,1005),
                                                                                    category,pageable);
        if (activityItems!=null){
            this.checkAndSetActivityStatus(activityItems);
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有可以参加的"+ ActivityCategory.codeOf(category)+"活动!");

    }



    public ServerResponse getActivityByStatusAndVoter(List<Integer> status, String userId,String sortField){
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,sortField);
        List<ActivityItem> activityItems = activityItemRepository.findByStatusInAndVoters(status,userId,pageable);
        if (activityItems!=null){
            this.checkAndSetActivityStatus(activityItems);
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有活动!");
    }

    public ServerResponse getActivityByStatusAndVoterAndCategory(List<Integer> status, String userId,int category,String sortField){
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,sortField);
        List<ActivityItem> activityItems = activityItemRepository.findAllStatusCategoryActivities(status,userId,category,pageable);
        if (activityItems!=null){
            this.checkAndSetActivityStatus(activityItems);
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有活动!");
    }

    public ServerResponse getOwnActivity(User user,String sortField){
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,sortField);
        List<ActivityItem> activityItems = activityItemRepository.findByOwnerUserId(user.getSubOpenId(),pageable);
        if (activityItems!=null){
            this.checkAndSetActivityStatus(activityItems);
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有创建活动!");
    }

    public ServerResponse getOwnActivityByCategory(User user,Integer category,String sortField){
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,sortField);
        List<ActivityItem> activityItems = activityItemRepository.findActivitiesOwnerUserIdAndCategory(category,user.getSubOpenId(),pageable);
        if (activityItems!=null){
            this.checkAndSetActivityStatus(activityItems);
            return ServerResponse.createBySuccess(activityItems);
        }
        return ServerResponse.createBySuccessMessage("暂时没有创建活动!");
    }

    public ServerResponse getActivityById(String id){
        ActivityItem activityItem = activityItemRepository.findById(id);
        if (activityItem != null){
            this.checkAndSetActivityStatus(Arrays.asList(activityItem));
            return ServerResponse.createBySuccess(activityItem);
        }
        return ServerResponse.createByErrorMessage("未查到活动!");
    }

    public ServerResponse deleteActivityById(User user,String id){
        ActivityItem activityItem = activityItemRepository.findById(id);
        if (!activityItem.getOwnerUser().getSubOpenId().equals(user.getSubOpenId())){
            return ServerResponse.createByErrorMessage("只能删除自己创建的活动！");
        }
        activityItemRepository.delete(activityItem);
        return ServerResponse.createBySuccessMessage("成功删除活动!");
    }

    public ServerResponse voteOnActivity(String userId,String activityId){
        ActivityItem activityItem = activityItemRepository.findById(activityId);
        if (new Date().getTime()>activityItem.getStartTime()){
            return ServerResponse.createByErrorMessage("活动已经开始!");
        }
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
            if (activityItem.getRealCount() == activityItem.getMaxCount()){
                ServerResponse.createByErrorMessage("报名人数已满！");
            }
            for (User voter:voters){
                if (voter.getSubOpenId().equals(userId)){
                    return ServerResponse.createByErrorMessage("您已经报过名了...");
                }
            }
            activityItem.setRealCount(activityItem.getRealCount()+1);
            activityItem.getVoters().add(user);
            if (activityItem.getRealCount() == activityItem.getMaxCount()){
                activityItem.setStatus(ActivityStatus.VOTED.getCode());
            }
            return ServerResponse.createBySuccess("报名成功",activityItemRepository.save(activityItem));
        }
    }

    private void checkAndSetActivityStatus(List<ActivityItem> activityItems){

        activityItems.stream().forEach(activityItem -> {
            if (new Date().getTime() >activityItem.getStartTime() && activityItem.getStatus()<ActivityStatus.PROCESSING.getCode()){
                activityItem.setStatus(ActivityStatus.PROCESSING.getCode());
                activityItemRepository.save(activityItem);
            }
            if (activityItem.getEndTime()<new Date().getTime() && activityItem.getStatus()<ActivityStatus.COMPLETE.getCode()){
                activityItem.setStatus(ActivityStatus.COMPLETE.getCode());
                activityItemRepository.save(activityItem);
            }
        });
    }

    public ServerResponse getActivityItemByCategory(String category) {
                return null;
    }
}
