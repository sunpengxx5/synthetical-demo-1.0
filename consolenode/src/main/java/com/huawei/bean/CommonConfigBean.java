package com.huawei.bean;

public class CommonConfigBean {
    private String goodsPictureCommonPath;

    public String getGoodsPicturePath(String pictureName) {
        return goodsPictureCommonPath + "/" + pictureName;
    }

    public void setGoodsPictureCommonPath(String goodsPictureCommonPath) {
        this.goodsPictureCommonPath = goodsPictureCommonPath;
    }
}
