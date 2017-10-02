package com.snow.dream.repository;

import com.snow.dream.entity.ActivityItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dghcch on 2017/9/27.
 */
@Repository
public interface ActivityItemRepository extends MongoRepository<ActivityItem,Integer> {
}
