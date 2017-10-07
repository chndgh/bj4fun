package com.snow.dream.service;

import com.snow.dream.utils.ServerResponse;

/**
 * Created by edward on 17/10/5.
 */
public interface UserService {

    ServerResponse login(String code);
}
