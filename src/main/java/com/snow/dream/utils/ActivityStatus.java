package com.snow.dream.utils;

/**
 * Created by dghcch on 2017/10/7.
 */
public enum ActivityStatus {
    CREATED(1001,"已创建"),
    VOTING(1002,"投票中"),
    VOTED(1003,"投票结束"),
    PROCESSING(1004,"正在进行中"),
    COMPLETE(1005,"活动结束");


    private String value;
    private int code;

    ActivityStatus(int code,String value){
        this.code = code;
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public int getCode(){
        return code;
    }

    public static ActivityStatus codeOf(int code){
        for (ActivityStatus activityStatus: values()){
            if (activityStatus.getCode()==code){
                return activityStatus;
            }
        }
        throw new RuntimeException("没有找到相应的枚举");
    }

}
