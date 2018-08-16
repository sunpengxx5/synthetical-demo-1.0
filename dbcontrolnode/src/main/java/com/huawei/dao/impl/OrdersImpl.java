package com.huawei.dao.impl;

import com.huawei.dao.OrdersDao;
import com.huawei.dao.mapper.OrdersMapper;
import com.huawei.projo.Orders;
import com.huawei.projo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrdersImpl implements OrdersDao {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> queryOrdersList(long userId) {
        return ordersMapper.queryOrdersList(userId);
    }

    @Override
    public int addOrders(Orders orders) {
        return ordersMapper.addOrders(orders);
    }

    @Override
    public int queryRushToBuySuccessCount(String userType,String tokenDefaultValue) {
        return ordersMapper.queryRushToBuySuccessCount(userType,tokenDefaultValue);
    }

    @Override
    public List<User> queryRushToBuySuccessUser(String userType,String tokenDefaultValue) {
        return ordersMapper.queryRushToBuySuccessUser(userType,tokenDefaultValue);
    }

}
