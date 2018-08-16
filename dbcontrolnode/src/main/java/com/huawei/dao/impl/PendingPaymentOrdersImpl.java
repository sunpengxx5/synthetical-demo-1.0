package com.huawei.dao.impl;

import com.huawei.Utils.CommonUtils;
import com.huawei.dao.*;
import com.huawei.dao.mapper.PendingPaymentOrdersMapper;
import com.huawei.projo.Orders;
import com.huawei.projo.PendingPaymentOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class PendingPaymentOrdersImpl implements PendingPaymentOrdersDao {

    @Resource
    private UserDao userDao;
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private GoodsDao goodsDao;

    @Autowired
    private PayDao paydao;

    @Autowired
    private PendingPaymentOrdersMapper pendingPaymentOrdersMapper;

    @Override
    public int batchAdd(List<PendingPaymentOrders> pendingPaymentOrdersList) {
        return pendingPaymentOrdersMapper.batchAdd(pendingPaymentOrdersList);
    }

    @Override
    public List<PendingPaymentOrders> queryPendingPaymentOrders(long userId) {
        return pendingPaymentOrdersMapper.queryPendingPaymentOrders(userId);
    }

    @Transactional
    @Override
    public String payPendingPaymentOrders(long ordersId,long userId,long goodsId,int goodsPrice) {
        String result;
        if(goodsDao.queryGoodsCount(goodsId) > 0){
            if(userDao.queryUserBalance(userId) > goodsPrice) {
                pendingPaymentOrdersMapper.updatePendingPaymentOrders(ordersId,CommonUtils.getNowTime());
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
