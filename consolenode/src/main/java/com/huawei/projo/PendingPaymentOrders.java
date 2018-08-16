package com.huawei.projo;

import com.alibaba.fastjson.JSONObject;

public class PendingPaymentOrders {
    private long goodsId;
    private long userId;
    private String goodsName;
    private String goodsPicturePath;
    private long ordersId;
    private int goodsPrice;

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPicturePath() {
        return goodsPicturePath;
    }

    public void setGoodsPicturePath(String goodsPicturePath) {
        this.goodsPicturePath = goodsPicturePath;
    }

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
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
        jsonObject.put("ordersId",ordersId);
        jsonObject.put("userId",userId);
        return jsonObject;
    }

    public static PendingPaymentOrders jsonToGoodsInCart(JSONObject jsonObject){
        PendingPaymentOrders pendingPaymentOrders =new PendingPaymentOrders();
        pendingPaymentOrders.setGoodsId(jsonObject.getLong("goodsId"));
        pendingPaymentOrders.setGoodsName(jsonObject.getString("goodsName"));
        pendingPaymentOrders.setGoodsPicturePath(jsonObject.getString("goodsPicturePath"));
        pendingPaymentOrders.setGoodsPrice(jsonObject.getInteger("goodsPrice"));
        pendingPaymentOrders.setOrdersId(jsonObject.getLong("ordersId"));
        pendingPaymentOrders.setUserId(jsonObject.getLong("userId"));
        return pendingPaymentOrders;
    }


}
