package com.huawei.dao.impl;

import com.huawei.dao.UserDao;
import com.huawei.dao.mapper.UserMapper;
import com.huawei.projo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User querySimpleUserInfoByName(String userName){
        return userMapper.querySimpleUserInfoByName(userName);
    }

    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    @Override
    public int updateUserBalance(int price,long userId) {
        return userMapper.updateUserBalance(price,userId);
    }

    @Override
    public int queryUserBalance(long userId) {
        return userMapper.queryUserBalance(userId);
    }

    @Override
    public User queryUserDetailInfoById(long userId) {
        return userMapper.queryUserDetailInfoById(userId);
    }

    @Override
    public long queryUserId(String userName) {
        return userMapper.queryUserId(userName);
    }

    @Override
    public int addUser(String userName,String userPwd,String userType){
        return userMapper.addTestUser(userName,userPwd,userType);
    }

    @Override
    public List<User> queryUser(String userType) {
        return userMapper.queryUser(userType);
    }

    @Override
    public int cleanUser(String userType) {
        return userMapper.cleanUser(userType);
    }

    @Override
    public int queryUserCount(String userType) {
        return userMapper.queryUserCount(userType);
    }

    @Override
    public int queryUserMaxId(String userType) {
        return userMapper.queryUserMaxId(userType);
    }

    @Override
    public int queryUserMinId(String userType) {
        return userMapper.queryUserMinId(userType);
    }

}
