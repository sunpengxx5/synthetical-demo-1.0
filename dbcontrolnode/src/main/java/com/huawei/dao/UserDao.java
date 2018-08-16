package com.huawei.dao;

import com.huawei.projo.User;

import java.util.List;

public interface UserDao {
    /**
     * create by: sunpeng
     * description:
     * create time: 19:15 2018/7/26
     *
     * @return 
     */
    User querySimpleUserInfoByName(String userName);

    /**
     * create by: sunpeng
     * description:
     * create time: 19:28 2018/7/26
     *
     * @return 
     */
    int addUser(User user);

    /**
     * create by: sunpeng
     * description:
     * create time: 0:29 2018/7/27
     *
     * @return
     */
    int updateUserBalance(int price,long userId);

    /**
     * create by: sunpeng
     * description:
     * create time: 11:44 2018/7/28
     *
     * @return
     */
    int queryUserBalance(long userId);

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    User queryUserDetailInfoById(long userId);
    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    long queryUserId(String userName);

    /**
     * create by: sunpeng
     * description:
     * create time: 19:28 2018/7/26
     *
     * @return
     */
    int addUser(String userName,String userPwd,String userType);

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    List<User> queryUser(String userType);

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    int cleanUser(String userType);

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    int queryUserCount(String userType);

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    int queryUserMaxId(String userType);

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    int queryUserMinId(String userType);

}
