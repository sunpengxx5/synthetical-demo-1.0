package com.huawei.service;

import com.huawei.Utils.CommonUtils;
import com.huawei.manager.KafkaManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTask {

    private static final int timeout = 200;

    @Autowired
    private ManagerService managerService;

    @Scheduled(fixedRate = 10)
    public void consumerTask(){
        managerService.recordRushToBuyOrders(timeout);
    }
}
