package com.snow.dream.utils;

/**
 * Created by dghcch on 2017/10/7.
 */
public enum ActivityCategory {
    SPORT(100,"运动"),
    EAT(101,"聚餐"),
    ENTERTAINING(102,"休闲娱乐"),
    TRAVEL(103,"旅游"),
    LEARNING(104,"学习"),
    MEETING(105,"会议");

    private String value;
    private int code;

    ActivityCategory(int code,String value){
        this.code = code;
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public int getCode(){
        return code;
    }

    public static ActivityCategory codeOf(int code){
        for (ActivityCategory activityCategory: values()){
            if (activityCategory.getCode()==code){
                return activityCategory;
            }
        }
        throw new RuntimeException("没有找到相应的枚举");
    }

}
