package com.snow.dream.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
public class User {
    private String openId;
    private String subOpenId;//openId 的前8位，用于搜索用户
    private String username;
    private Integer gender;
    private String nickName;
    private String country;
    private String province;
    private String city;
    private String language;
    private String avatarUrl;
    private Integer role; //1，普通用户；10，小组管理员；110，管理员，可以发布公告全员可见的活动
    private String groupId;
    private List<String> activities; //用户参加过的活动
    private String jsCode; //登录时返回的code
    private Long firstLoginTime;
    private Long registerTime;
    private Long latestLoginTime;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Id
    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public Long getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Long firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Long latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }
}
