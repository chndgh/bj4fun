package com.snow.dream.entity;

import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
public class ActivityItem {

    private String id; //活动Id
    private String title;   //活动名称
    private Integer category; //活动类别
    private Long createTime; //活动创建时间
    private Long startTime; //活动开始时间
    private Long endTime;//活动结束时间
    private String address; //活动地点
    private String description;//活动的描述
    private User ownerUser;//创建活动的人
    private List<User> voters;//投票参加活动的人
    private Integer maxCount; //活动最多人数
    private Integer realCount;//活动实际人数
    private Integer isOpen; //是否公开活动
    private Long cost;//人均费用
    private String groupId;//活动所属的组织
    private Integer status; //1001，已创建，未发布； 1002，投票阶段； 1003，投票结束，未开始；1004，正在进行中；1005，结束

    private String actPortraitUrl;
    private List<String> actDescUrls;
    private List<ActivityPosition> positions;//活动具体的位置，通过getPosition获得经纬度

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getVoters() {
        return voters;
    }

    public void setVoters(List<User> voters) {
        this.voters = voters;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public Integer getRealCount() {
        return realCount;
    }

    public void setRealCount(Integer realCount) {
        this.realCount = realCount;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActPortraitUrl() {
        return actPortraitUrl;
    }

    public void setActPortraitUrl(String actPortraitUrl) {
        this.actPortraitUrl = actPortraitUrl;
    }

    public List<String> getActDescUrls() {
        return actDescUrls;
    }

    public void setActDescUrls(List<String> actDescUrls) {
        this.actDescUrls = actDescUrls;
    }

    public List<ActivityPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<ActivityPosition> positions) {
        this.positions = positions;
    }

    public static class ActivityPosition{
        private String longitude;
        private String latitude;
        private String address;


        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
