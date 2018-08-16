package com.huawei.projo;

import com.alibaba.fastjson.JSONObject;

public class Orders {
    private long ordersId;
    private String ordersDate;
    private long userId;
    private long goodsId;
    private String goodsName;
    private int goodsPrice;
    private String goodsPicturePath;


    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

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

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    public String getGoodsPicturePath() {
        return goodsPicturePath;
    }

    public void setGoodsPicturePath(String goodsPicturePath) {
        this.goodsPicturePath = goodsPicturePath;
    }

    @Override
    public String toString() {
        return toJson().toJSONString();
    }

    public JSONObject toJson(){
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("ordersId",ordersId);
        jsonObject.put("goodsId",goodsId);
        jsonObject.put("goodsName",goodsName);
        jsonObject.put("goodsPrice",goodsPrice);
        jsonObject.put("ordersDate",ordersDate);
        jsonObject.put("goodsPicturePath",goodsPicturePath);
        return jsonObject;
    }

    public static Orders jsonToOrders(JSONObject jsonObject){
        Orders orders = new Orders();
        orders.setOrdersId(jsonObject.getInteger("ordersId"));
        orders.setOrdersDate(jsonObject.getString("ordersDate"));
        orders.setGoodsName(jsonObject.getString("goodsName"));
        orders.setGoodsPicturePath(jsonObject.getString("goodsPicturePath"));
        orders.setGoodsPrice(jsonObject.getInteger("goodsPrice"));
        return orders;

    }

}
