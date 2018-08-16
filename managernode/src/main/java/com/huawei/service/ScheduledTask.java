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

    private static Logger log = Logger.getLogger(ManagerService.class);

    @Autowired
    private KafkaManager kafkaManager;

    @Autowired
    private ManagerService managerService;

    @Scheduled(fixedRate = 60000)
    public void heartbeat(){
        kafkaManager.produceMsg(CommonUtils.HEARTBEAT);
        log.info(CommonUtils.HEARTBEAT);
    }

}
