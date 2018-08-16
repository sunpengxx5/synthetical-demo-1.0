package com.huawei.dao.mapper;

import com.huawei.projo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

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
     * create time: 11:37 2018/7/28
     *
     * @return
     */
    int updateGoodsCount(@Param("goodsId")long goodsId,@Param("count")int count);

    /**
     * create by: sunpeng
     * description:
     * create time: 11:44 2018/7/28
     *
     * @return
     */
    int queryGoodsCount(long goodsId);
}
