package com.huawei.dao.mapper;

import com.huawei.projo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * create by: sunpeng
     * description:
     * create time: 19:50 2018/7/26
     *
     * @reurn
     */
    int addUser(User user);

    /**
     * create by: sunpeng
     * description:
     * create time: 19:28 2018/7/26
     *
     * @return
     */
    int addTestUser(@Param("userName")String userName,@Param("userPwd")String userPwd,@Param("userType")String userType);
    /**
     * create by: sunpeng
     * description:
     * create time: 19:50 2018/7/26
     *
     * @return 
     */
    User querySimpleUserInfoByName(String userName);
    /**
     * create by: sunpeng
     * description:
     * create time: 0:30 2018/7/27
     *
     * @return
     */
    int updateUserBalance(@Param("price")int price,@Param("userId")long userId);

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

    /**
     * create by: sunpeng
     * description:
     * create time: 14:45 2018/7/28
     *
     * @return
     */
    List<User> queryUser(String userType);

    long queryUserId(String userName);
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
