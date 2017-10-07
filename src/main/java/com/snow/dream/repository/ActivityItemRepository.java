package com.snow.dream.repository;

import com.snow.dream.entity.ActivityItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
@Repository
public interface ActivityItemRepository extends MongoRepository<ActivityItem,Integer> {

    List<ActivityItem> findByCategoryAndVotersIn(String category, List<String> userIds);

    List<ActivityItem> findByOwnerUserId(String ownerUserId);

    List<ActivityItem> findByStatusAndVoters(Integer status, String userId);


    @Query("{'startTime':{$lte:?0},'endTime':{$gte:?0},voters:{$in:?1}}" )
    List<ActivityItem> findAllActiveActivity(Long time, String userId);

    @Query("{'endTime':{$lte:?0},voters:{$in:?1}}")
    List<ActivityItem> findAllInActiveActivity(Long time, String userId);



}