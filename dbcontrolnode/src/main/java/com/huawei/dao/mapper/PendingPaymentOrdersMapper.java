package com.huawei.dao.mapper;

import com.huawei.projo.PendingPaymentOrders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PendingPaymentOrdersMapper {
    /**
     * create by: sunpeng
     * description:
     * create time: 12:04 2018/8/13
     *
     * @return
     */
    int batchAdd(@Param("pendingPaymentOrdersList")List<PendingPaymentOrders> pendingPaymentOrdersList);

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
    int updatePendingPaymentOrders(@Param("ordersId") long ordersId,@Param("date") String date);

}
