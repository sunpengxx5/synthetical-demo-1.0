package com.huawei.projo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class User {
    private long userId;
    private String userName;
    private String userPwd;
    private int userBalance;
    private String userSex;
    private int userLevel;
    private String userHeadPortraitPath;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserHeadPortraitPath() {
        return userHeadPortraitPath;
    }

    public void setUserHeadPortraitPath(String userHeadPortraitPath) {
        this.userHeadPortraitPath = userHeadPortraitPath;
    }

    @Override
    public String toString() {
        return toJson().toJSONString();
    }

    public JSONObject toJson(){
        JSONObject object = new JSONObject();
        object.put("userId", userId);
        object.put("userName", userName);
        object.put("userPwd",userPwd);
        object.put("userBalance",userBalance);
        object.put("userSex", userSex);
        object.put("userLevel",userLevel);
        object.put("userHeadPortraitPath",userHeadPortraitPath);
        return object;
    }
    public JSONObject toSimpleJson() {
        JSONObject object = new JSONObject();
        object.put("userId", userId);
        object.put("userName", userName);
        object.put("userPwd",userPwd);
        return object;
    }

    public JSONObject toSimpleJson2() {
        JSONObject object = new JSONObject();
        object.put("userId", userId);
        object.put("userName", userName);
        return object;
    }

    public static JSONArray toJsonArray(List<User> userList){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<userList.size();i++){
            jsonArray.add(userList.get(i).toSimpleJson());
        }
        return jsonArray;
    }

    public JSONObject toDetailJson() {
        JSONObject object = new JSONObject();
        object.put("userId", userId);
        object.put("userName", userName);
        object.put("userBalance",userBalance);
        object.put("userSex", userSex);
        object.put("userLevel",userLevel);
        object.put("userHeadPortraitPath",userHeadPortraitPath);
        return object;
    }
}
