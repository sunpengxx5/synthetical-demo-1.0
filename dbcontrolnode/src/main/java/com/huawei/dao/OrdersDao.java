package com.huawei.dao;

import com.huawei.projo.Orders;
import com.huawei.projo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrdersDao {

    /**
     * create by: sunpeng
     * description:
     * create time: 19:19 2018/7/26
     *
     * @return
     */
    List<Orders> queryOrdersList(long userId);

    /**
     * create by: sunpeng
     * description:
     * create time: 0:19 2018/7/27
     *
     * @return
     */
    int addOrders(Orders orders);

    /**
     * create by: sunpeng
     * description:
     * create time: 0:19 2018/7/27
     *
     * @return
     */
    int queryRushToBuySuccessCount(String userType,String tokenDefaultValue);
    /**
     * create by: sunpeng
     * description:
     * create time: 0:19 2018/7/27
     *
     * @return
     */
    List<User> queryRushToBuySuccessUser(String userType,String tokenDefaultValue);
}
