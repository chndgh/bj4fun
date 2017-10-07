package com.snow.dream.service.impl;

import com.snow.dream.entity.SecretEntity;
import com.snow.dream.entity.User;
import com.snow.dream.repository.UserRepository;
import com.snow.dream.service.UserService;
import com.snow.dream.utils.ServerResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Date;

/**
 * Created by edward on 17/10/5.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${wechat.app.id}")
    String appid;

    @Value("${wechat.app.secret}")
    String secret;

    @Value("${wechat.app.grant_type}")
    String grant_type;

    @Value("${wechat.app.url}")
    String url;

    public ServerResponse login(User user){
        String openId = retrieveOpenId(user.getJsCode());
        String subOpenId;
        if (openId!=null && !"".equals(openId))
        {
            subOpenId = openId.substring(0,7);
            User dbUser = findUserBySubOpenId(subOpenId);
            if (dbUser!=null){
                dbUser.setLatestLoginTime(new Date().getTime());
                userRepository.save(dbUser);
                return ServerResponse.createBySuccess("欢迎老用户",dbUser);
            }else{
                user.setOpenId(openId);
                user.setSubOpenId(subOpenId);
                User firstLoginUser = createUser(user);
                return ServerResponse.createBySuccess("第一次登陆的用户",firstLoginUser);
            }
        }
        return ServerResponse.createByErrorMessage("无法获取用户的openId");
    }

    private User createUser(User user){
        user.setFirstLoginTime(new Date().getTime());
        User item = userRepository.save(user);
        return item;
    }


    private String retrieveOpenId(String code){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("appid", appid)
                .queryParam("secret", secret)
                .queryParam("js_code", code)
                .queryParam("grant_type", grant_type);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                String.class);
        try {
            ObjectMapper mapper = new ObjectMapper();
            SecretEntity secretEntity = mapper.readValue(response.getBody().toString(),SecretEntity.class);
            return secretEntity.getOpenid();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private User findUserBySubOpenId(String subOpenId){
        User user = userRepository.findOne(subOpenId);
        if (user !=null){
            return user;
        }
        return null;
    }
}
