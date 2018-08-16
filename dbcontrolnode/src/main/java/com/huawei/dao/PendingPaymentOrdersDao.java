package com.huawei.dao;

import com.huawei.projo.PendingPaymentOrders;

import java.util.List;

public interface PendingPaymentOrdersDao {

    /**
     * create by: sunpeng
     * description:
     * create time: 12:04 2018/8/13
     *
     * @return 
     */
    int batchAdd(List<PendingPaymentOrders> pendingPaymentOrdersList);

    /**
     * create by: sunpeng
     * description:
   12:04r2018/8/13: 12:04 2018/8/1
     *
     * @return a
     */
    List<PendingPaymentOrders> queryPendingPaymentOrders(long userId);

    /**
     * create by: sunpeng
     * description:
     * create time: 16:58 2018/8/14
     *
     * @return
     */
    String payPendingPaymentOrders(long ordersId,long userId,long goodsId,int goodsPrice);

}
