package com.huawei.configbean;

public class DbServicesConfigBean {
    private String hostAndPort;
    private String addTestUserMethod;
    private String queryTestUserMethod;
    private String cleanTestUserMethod;
    private String queryRushToBuySuccessUserMethod;
    private String queryRushToBuySuccessCountMethod;
    private String queryTestUserCountMethod;
    private String queryGoodsListMethod;
    private String queryTestUserIdRangeMethod;

    public void setHostAndPort(String hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

    public String getAddTestUserMethodUrl(int count) {
        return hostAndPort + "/" + addTestUserMethod + "?count=" + count;
    }

    public void setAddTestUserMethod(String addTestUserMethod) {
        this.addTestUserMethod = addTestUserMethod;
    }

    public String getQueryTestUserMethodUrl() {
        return hostAndPort + "/" + queryTestUserMethod;
    }

    public void setQueryTestUserMethod(String queryTestUserMethod) {
        this.queryTestUserMethod = queryTestUserMethod;
    }

    public String getCleanTestUserMethodUrl() {
        return hostAndPort + "/" + cleanTestUserMethod;
    }

    public void setCleanTestUserMethod(String cleanTestUserMethod) {
        this.cleanTestUserMethod = cleanTestUserMethod;
    }

    public String getQueryRushToBuySuccessUserMethodUrl() {
        return hostAndPort + "/" + queryRushToBuySuccessUserMethod;
    }

    public void setQueryRushToBuySuccessUserMethod(String queryRushToBuySuccessUserMethod) {
        this.queryRushToBuySuccessUserMethod = queryRushToBuySuccessUserMethod;
    }

    public String getQueryRushToBuySuccessCountMethodUrl() {
        return hostAndPort + "/" + queryRushToBuySuccessCountMethod;
    }

    public void setQueryRushToBuySuccessCountMethod(String queryRushToBuySuccessCountMethod) {
        this.queryRushToBuySuccessCountMethod = queryRushToBuySuccessCountMethod;
    }

    public String getQueryTestUserCountMethodUrl() {
        return hostAndPort + "/" + queryTestUserCountMethod;
    }

    public void setQueryTestUserCountMethod(String queryTestUserCountMethod) {
        this.queryTestUserCountMethod = queryTestUserCountMethod;
    }

    public String getQueryGoodsListMethodUrl(String goodsType) {
        return hostAndPort + "/" + queryGoodsListMethod + "?goodsType=" + goodsType;
    }

    public void setQueryGoodsListMethod(String queryGoodsListMethod) {
        this.queryGoodsListMethod = queryGoodsListMethod;
    }

    public String getQueryTestUserIdRangeMethodUrl() {
        return hostAndPort + "/" + queryTestUserIdRangeMethod;
    }

    public void setQueryTestUserIdRangeMethod(String queryTestUserIdRangeMethod) {
        this.queryTestUserIdRangeMethod = queryTestUserIdRangeMethod;
    }
}
