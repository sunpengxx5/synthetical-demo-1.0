package com.huawei.runnable;

import com.huawei.service.ConsoleBackstageService;
import com.huawei.tools.PrePareRushToBuyTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class PrepareTestUserRunnable implements Runnable{

    private static Logger log = Logger.getLogger(PrepareTestUserRunnable.class);

    @Autowired
    private ConsoleBackstageService consoleBackstageService;

    private int count = 100;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        boolean result = consoleBackstageService.initTestUser(this.count);
        log.info("PrepareTestUser:" + result);
        PrePareRushToBuyTools.resetPrivilegeOfCommitData(PrePareRushToBuyTools.PREPARE_TEST_USER);
    }
}
