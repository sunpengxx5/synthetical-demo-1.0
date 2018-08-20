package com.huawei.configbean;

public class DbServicesConfigBean {
    private String hostAndPort;
    private String querySimpleUserInfoMethod;
    private String queryUserDetailInfoByIdMethod;
    private String addUserMethod;
    private String queryGoodsDetailMethod;
    private String queryGoodsListMethod;
    private String queryOrdersListMethod;
    private String payMethod;
    private String batchAddPendingPaymentMethod;
    private String queryPendingPaymentMethod;
    private String payPendingPaymentMethod;
    private String queryGoodsCountMethod;

    public void setHostAndPort(String hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

    public void setQuerySimpleUserInfoMethod(String querySimpleUserInfoMethod) {
        this.querySimpleUserInfoMethod = querySimpleUserInfoMethod;
    }

    public void setQueryUserDetailInfoByIdMethod(String queryUserDetailInfoByIdMethod) {
        this.queryUserDetailInfoByIdMethod = queryUserDetailInfoByIdMethod;
    }

    public void setAddUserMethod(String addUserMethod) {
        this.addUserMethod = addUserMethod;
    }

    public void setQueryGoodsDetailMethod(String queryGoodsDetailMethod) {
        this.queryGoodsDetailMethod = queryGoodsDetailMethod;
    }

    public void setQueryGoodsListMethod(String queryGoodsListMethod) {
        this.queryGoodsListMethod = queryGoodsListMethod;
    }

    public void setQueryOrdersListMethod(String queryOrdersListMethod) {
        this.queryOrdersListMethod = queryOrdersListMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }


    public String querySimpleUserInfoUrl() {
        return hostAndPort + "/" + querySimpleUserInfoMethod;
    }

    public String queryUserDetailInfoByIdUrl() {
        return hostAndPort + "/" + queryUserDetailInfoByIdMethod;
    }

    public String getAddUserUrl() {
        return hostAndPort + "/" + addUserMethod;
    }

    public String getQueryGoodsDetailUrl(String goodsId) {
        return hostAndPort + "/" + queryGoodsDetailMethod + "?goodsId=" + goodsId;
    }

    public String getQueryGoodsListUrl(String goodsType) {
        return hostAndPort + "/" + queryGoodsListMethod + "?goodsType=" + goodsType;
    }

    public String getQueryOrdersListUrl() {
        return hostAndPort + "/" + queryOrdersListMethod;
    }

    public String getPayUrl() {
        return hostAndPort + "/" + payMethod;
    }

    public String getBatchAddPendingPaymentMethodUrl() {
        return hostAndPort + "/" + batchAddPendingPaymentMethod;
    }

    public void setBatchAddPendingPaymentMethod(String batchAddPendingPaymentMethod) {
        this.batchAddPendingPaymentMethod = batchAddPendingPaymentMethod;
    }

    public String getQueryPendingPaymentMethodUrl(String userId) {
        return hostAndPort + "/" + queryPendingPaymentMethod + "?userId=" + userId;
    }

    public void setQueryPendingPaymentMethod(String queryPendingPaymentMethod) {
        this.queryPendingPaymentMethod = queryPendingPaymentMethod;
    }

    public String getPayPendingPaymentMethodUrl() {
        return hostAndPort + "/" + payPendingPaymentMethod;
    }

    public void setPayPendingPaymentMethod(String payPendingPaymentMethod) {
        this.payPendingPaymentMethod = payPendingPaymentMethod;
    }

    public String getQueryGoodsCountMethodUrl(String goodsId) {
        return hostAndPort + "/" + queryGoodsCountMethod + "?goodsId=" + goodsId;
    }

    public void setQueryGoodsCountMethod(String queryGoodsCountMethod) {
        this.queryGoodsCountMethod = queryGoodsCountMethod;
    }
}
