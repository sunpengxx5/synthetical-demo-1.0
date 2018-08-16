package com.huawei.configbean;

public class ManagerServicesConfigBean {
    private String managerServicesUrl;
    private String signInMethod;
    private String signUpMethod;
    private String userDetailMethod;
    private String goodsListMethod;
    private String goodsDetailMethod;
    private String payMethod;
    private String orderListMethod;
    private String rushToBuyMethod;

    public String getManagerServicesUrl() {
        return managerServicesUrl;
    }

    public void setManagerServicesUrl(String managerServicesUrl) {
        this.managerServicesUrl = managerServicesUrl;
    }

    public String getSignInMethodUrl() {
        return managerServicesUrl + "/" + signInMethod;
    }

    public void setSignInMethod(String signInMethod) {
        this.signInMethod = signInMethod;
    }

    public String getSignUpMethodUrl() {
        return managerServicesUrl + "/" + signUpMethod;
    }

    public void setSignUpMethod(String signUpMethod) {
        this.signUpMethod = signUpMethod;
    }

    public String getUserDetailMethodUrl() {
        return managerServicesUrl + "/" + userDetailMethod;
    }

    public void setUserDetailMethod(String userDetailMethod) {
        this.userDetailMethod = userDetailMethod;
    }

    public String getGoodsListMethodUrl(String goodsType) {
        return managerServicesUrl + "/" + goodsListMethod + "?goodsType=" +goodsType;
    }

    public void setGoodsListMethod(String goodsListMethod) {
        this.goodsListMethod = goodsListMethod;
    }

    public String getGoodsDetailMethodUrl(String goodsId,String goodsType) {
        return managerServicesUrl + "/" + goodsDetailMethod + "?goodsId=" +goodsId + "&goodsType=" + goodsType;
    }

    public void setGoodsDetailMethod(String goodsDetailMethod) {
        this.goodsDetailMethod = goodsDetailMethod;
    }

    public String getPayMethodUrl() {
        return managerServicesUrl + "/" + payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getOrderListMethodUrl() {
        return managerServicesUrl + "/" + orderListMethod;
    }

    public void setOrderListMethod(String orderListMethod) {
        this.orderListMethod = orderListMethod;
    }

    public String getRushToBuyMethodUrl() {
        return rushToBuyMethod;
    }

    public void setRushToBuyMethod(String rushToBuyMethod) {
        this.rushToBuyMethod = managerServicesUrl + "/" + rushToBuyMethod;
    }
}
