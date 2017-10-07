package com.snow.dream.utils;

/**
 * Created by dghcch on 2017/10/7.
 */
public enum ActivityCategory {
    INDOORSPORT(0,"室内运动"),
    OUTDOORSPORT(1,"户外运动"),
    INDOORLEISURE(2,"室内休闲"),
    OUTDOORLEISURE(3,"户外休闲");

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
