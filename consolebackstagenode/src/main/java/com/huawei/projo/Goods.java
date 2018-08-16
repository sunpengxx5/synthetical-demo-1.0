package com.huawei.projo;

import com.alibaba.fastjson.JSONObject;

public class Goods {
    private long goodsId;
    private String goodsName;
    private int goodsPrice;
    private String goodsPicturePath;
    private String goodsDescribe;
    private String goodsType;
    private String goodsCount;

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPicturePath() {
        return goodsPicturePath;
    }

    public void setGoodsPicturePath(String goodsPicturePath) {
        this.goodsPicturePath = goodsPicturePath;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return toJson().toJSONString();
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("goodsId",goodsId);
        jsonObject.put("goodsName",goodsName);
        jsonObject.put("goodsPrice",goodsPrice);
        jsonObject.put("goodsPicturePath",goodsPicturePath);
        jsonObject.put("goodsDescribe",goodsDescribe);
        jsonObject.put("goodsType",goodsType);
        jsonObject.put("goodsCount",goodsCount);
        return jsonObject;
    }

    public static Goods jsonToSimpleGoods(JSONObject jsonObject){
        Goods goods = new Goods();
        goods.setGoodsId(jsonObject.getLong("goodsId"));
        goods.setGoodsName(jsonObject.getString("goodsName"));
        goods.setGoodsPicturePath(jsonObject.getString("goodsPicturePath"));
        goods.setGoodsPrice(jsonObject.getInteger("goodsPrice"));
        return goods;
    }

    public static Goods jsonToDetailGoods(JSONObject jsonObject){
        Goods goods = jsonToSimpleGoods(jsonObject);
        goods.setGoodsDescribe(jsonObject.getString("goodsDescribe"));
        goods.setGoodsCount(jsonObject.getString("goodsCount"));
        goods.setGoodsType(jsonObject.getString("goodsType"));
        return goods;
    }
}
