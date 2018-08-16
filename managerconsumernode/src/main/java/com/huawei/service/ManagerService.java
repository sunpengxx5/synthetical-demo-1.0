package com.huawei.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.configbean.DbServicesConfigBean;
import com.huawei.manager.KafkaManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ManagerService {

    private static Logger log = Logger.getLogger(ManagerService.class);

    @Autowired
    private DbServicesConfigBean dbServicesConfigBean;

    @Autowired
    private KafkaManager kafkaManager;

    @Autowired
    private DataService dataService;

    public void recordRushToBuyOrders(int timeout){
        JSONArray jsonArray = kafkaManager.consumeMsg(timeout);
        if( jsonArray.size() > 0 ){
            String url = dbServicesConfigBean.getBatchAddPendingPaymentMethodUrl();
            Map<String,Object> urlVariables = new HashMap<>();
            urlVariables.put("pendingPayments",jsonArray.toJSONString());
            JSONObject jsonObject = dataService.getDataFromDbService( url, urlVariables, DataService.POST_Method_TYPE);
            log.info("recordRushToBuyOrders:" + jsonObject.toJSONString());
        }
    }

}
