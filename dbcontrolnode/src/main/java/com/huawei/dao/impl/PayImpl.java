package com.huawei.dao.impl;

import com.huawei.Utils.CommonUtils;
import com.huawei.dao.GoodsDao;
import com.huawei.dao.OrdersDao;
import com.huawei.dao.PayDao;
import com.huawei.dao.UserDao;
import com.huawei.projo.Orders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class PayImpl implements PayDao {

    @Resource
    private UserDao userDao;
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private GoodsDao goodsDao;

    @Transactional
    @Override
    public String pay(long userId,long goodsId,int goodsPrice) {
        String result;
        if(goodsDao.queryGoodsCount(goodsId) > 0){
            if(userDao.queryUserBalance(userId) > goodsPrice) {
                Orders orders = new Orders();
                orders.setUserId(userId);
                orders.setGoodsId(goodsId);
                orders.setOrdersDate(CommonUtils.getNowTime());
                orders.setPayed(true);
                ordersDao.addOrders(orders);
                userDao.updateUserBalance(goodsPrice, userId);
                goodsDao.updateGoodsCount(goodsId,1);
                result = CommonUtils.PAY_SUCCESS;
            }else {
                result = CommonUtils.NOT_SUFFICIENT_FUNDS;
            }
        }else {
            result = CommonUtils.LACK_OF_STOCK;
        }
        return result;
    }
}
