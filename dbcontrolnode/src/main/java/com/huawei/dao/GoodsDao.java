package com.huawei.dao;

import com.huawei.projo.Goods;

import java.util.List;

public interface GoodsDao {
    /**
     * create by: sunpeng
     * description:
     * create time: 19:20 2018/7/26
     *
     * @return
     */
    List<Goods> queryGoodsList(String goodsType);

    /**
     * create by: sunpeng
     * description:
     * create time: 19:21 2018/7/26
     *
     * @return
     */
    Goods queryGoodsDetail(long goodsId);

    /**
     * create by: sunpeng
     * description:
     * create time: 11:35 2018/7/28
     *
     * @return
     */
    int updateGoodsCount(long goodsId,int count);

    /**
     * create by: sunpeng
     * description:
     * create time: 11:44 2018/7/28
     *
     * @return
     */
    int queryGoodsCount(long goodsId);
}
