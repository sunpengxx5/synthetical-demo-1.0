package com.huawei.bean;

public class ConsoleBackStageConfigBean {
    private String consoleBackstageHost;
    private String rushToBuyScene;


    public void setConsoleBackstageHost(String consoleBackstageHost) {
        this.consoleBackstageHost = consoleBackstageHost;
    }

    public String getRushToBuySceneURL() {
        return consoleBackstageHost + "/" +rushToBuyScene;
    }

    public void setRushToBuyScene(String rushToBuyScene) {
        this.rushToBuyScene = rushToBuyScene;
    }
}
