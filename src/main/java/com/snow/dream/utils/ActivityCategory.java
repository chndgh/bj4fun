package com.snow.dream.utils;

/**
 * Created by dghcch on 2017/10/7.
 */
public enum ActivityCategory {
    SPORT(0,"运动"),
    EAT(1,"聚餐"),
    ENTERTAINING(2,"休闲娱乐"),
    TRAVEL(3,"旅游"),
    LEARNING(4,"学习"),
    MEETING(5,"会议");

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
