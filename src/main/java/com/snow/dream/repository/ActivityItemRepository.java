package com.snow.dream.repository;

import com.snow.dream.entity.ActivityItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
@Repository
public interface ActivityItemRepository extends MongoRepository<ActivityItem,Integer> {

    @Query("{'ownerUser._id':?0}")
    List<ActivityItem> findByOwnerUserId(String ownerUserId,Pageable pageable);

    @Query("{'category':?0,'ownerUser._id':?1}")
    List<ActivityItem> findActivitiesOwnerUserIdAndCategory(Integer category, String ownerUserId,Pageable pageable);

    ActivityItem findById(String id);

    @Query("{'status':{$in:?0},'voters._id':?1}")
    List<ActivityItem> findByStatusInAndVoters(List<Integer> status, String userId,Pageable pageable);

    @Query("{'status':{$in:?0},'voters._id':?1,'category':?2}")
    List<ActivityItem> findAllStatusCategoryActivities(List<Integer> status,String userId,int category,Pageable pageable);

    @Query("{'ownerUser._id':{$ne:?0},'voters._id':{$ne:?0},'isOpen':1,'status':{$in:?1}}")
    List<ActivityItem> findAvailableActivities(String userId,List<Integer> status,Pageable pageable);

    @Query("{'ownerUser._id':{$ne:?0},'voters._id':{$ne:?0},'isOpen':1,'status':{$in:?1},'category':?2}")
    List<ActivityItem> findAvailableCategoryActivities(String userId,List<Integer> status,Integer category,Pageable pageable);

}