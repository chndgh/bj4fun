package com.snow.dream.repository;

import com.snow.dream.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by edward on 17/10/5.
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
