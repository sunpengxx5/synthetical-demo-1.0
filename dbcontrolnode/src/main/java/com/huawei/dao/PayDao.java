package com.huawei.dao;

public interface PayDao {
    /**
     * create by: sunpeng
     * description:
     * create time: 11:53 2018/8/13
     *
     * @return 
     */
    String pay(long userId,long goodsId,int goodsPrice);
}
