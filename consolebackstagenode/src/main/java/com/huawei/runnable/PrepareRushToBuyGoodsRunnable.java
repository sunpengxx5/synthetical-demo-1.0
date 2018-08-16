package com.huawei.runnable;

import com.huawei.service.ConsoleBackstageService;
import com.huawei.tools.PrePareRushToBuyTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class PrepareRushToBuyGoodsRunnable implements Runnable {

    private static Logger log = Logger.getLogger(PrepareRushToBuyGoodsRunnable.class);

    @Autowired
    private ConsoleBackstageService consoleBackstageService;

    private int count = 100;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        boolean result = consoleBackstageService.initRushToBuyGoods(this.count);
        log.info("PrepareRushToBuyGoods:" + result);
        PrePareRushToBuyTools.resetPrivilegeOfCommitData(PrePareRushToBuyTools.PREPARE_RUSH_TO_BUY_GOODS);
    }
}
