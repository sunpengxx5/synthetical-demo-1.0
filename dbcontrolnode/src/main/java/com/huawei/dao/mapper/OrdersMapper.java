package com.huawei.dao.mapper;

import com.huawei.projo.Orders;
import com.huawei.projo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
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
     * create time: 0:35 2018/7/27
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
    int queryRushToBuySuccessCount(@Param("userType")String userType, @Param("tokenDefaultValue")String tokenDefaultValue);
    /**
     * create by: sunpeng
     * description:
     * create time: 0:19 2018/7/27
     *
     * @return
     */
    List<User>  queryRushToBuySuccessUser(@Param("userType")String userType,@Param("tokenDefaultValue")String tokenDefaultValue);

}
