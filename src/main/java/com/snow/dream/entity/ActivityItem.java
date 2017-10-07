package com.snow.dream.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by dghcch on 2017/9/27.
 */
public class ActivityItem {

    private String id; //活动Id
    private String title;   //活动名称
    private String category; //活动类别
    private Long startTime; //活动开始时间
    private Long endTime;//活动结束时间
    private String description;//活动的描述
    private String ownerUserId;//创建活动的人
    private List<String> voters;//投票参加活动的人
    private Integer maxCount; //活动最多人数
    private Integer realCount;//活动实际人数
    private Long cost;//活动费用
    private String groupId;//活动所属的组织
    private Integer status; //1001，已创建，未发布； 1002，投票阶段； 1003，投票结束，未开始；1004，正在进行中；1005，结束

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public List<String> getVoters() {
        return voters;
    }

    public void setVoters(List<String> voters) {
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
}
