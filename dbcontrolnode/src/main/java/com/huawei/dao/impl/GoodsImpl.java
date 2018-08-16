package com.huawei.dao.impl;

import com.huawei.dao.GoodsDao;
import com.huawei.dao.mapper.GoodsMapper;
import com.huawei.projo.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsImpl implements GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoodsList(String goodsType) {
        return goodsMapper.queryGoodsList(goodsType);
    }

    @Override
    public Goods queryGoodsDetail(long goodsId) {
        return goodsMapper.queryGoodsDetail(goodsId);
    }

    @Override
    public int updateGoodsCount(long goodsId,int count) {
        return goodsMapper.updateGoodsCount(goodsId,count);
    }

    @Override
    public int queryGoodsCount(long goodsId) {
        return goodsMapper.queryGoodsCount(goodsId);
    }
}
