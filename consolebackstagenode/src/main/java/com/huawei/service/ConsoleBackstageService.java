package com.huawei.service;

import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.Utils.JSONAnalysis;
import com.huawei.configbean.DbServicesConfigBean;
import com.huawei.runnable.PrepareRushToBuyGoodsRunnable;
import com.huawei.runnable.PrepareTestUserRunnable;
import com.huawei.tools.PrePareRushToBuyTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsoleBackstageService {

    private static Logger log = Logger.getLogger(ConsoleBackstageService.class);

    @Autowired
    private DataService dataService;

    @Autowired
    private DbServicesConfigBean dbServicesConfigBean;

    @Autowired
    private PrepareTestUserRunnable prepareTestUserRunnable;

    @Autowired
    private PrepareRushToBuyGoodsRunnable prepareRushToBuyGoodsRunnable;

    public int queryTestUserCount(){
        String url = dbServicesConfigBean.getQueryTestUserCountMethodUrl();
        JSONObject resultJson = dataService.getDataFromManagerServices(url, dataService.GET_Method_TYPE);
        return JSONAnalysis.analysisForObjectCount(resultJson,"testUserCount");
    }

    public String queryRushToBuyGoodsDetail(){
        String result = "";
        String url = dbServicesConfigBean.getQueryGoodsListMethodUrl(CommonUtils.GOODS_TYPE_RUSH_TO_BUY);
        JSONObject resultJson = dataService.getDataFromManagerServices(url, dataService.GET_Method_TYPE);
        JSONObject jsonObject = JSONAnalysis.analysisObjectJson(resultJson);
        if (jsonObject != null){
            jsonObject.put("goodsType",CommonUtils.GOODS_TYPE_RUSH_TO_BUY);
            result = jsonObject.toJSONString();
        }
        return result;
    }
    public String testUserIdRange(){
        String url = dbServicesConfigBean.getQueryTestUserIdRangeMethodUrl();
        JSONObject resultJson = dataService.getDataFromManagerServices(url, dataService.GET_Method_TYPE);
        return JSONAnalysis.analysisObjectString(resultJson,"testUserIdRange");
    }
    public String rushToBuy(String url,Map<String,Object> urlMap){

        long startTime = System.currentTimeMillis();
        JSONObject responseJson = dataService.getDataFromManagerServices(url,urlMap, dataService.POST_Method_TYPE);
        long endTime = System.currentTimeMillis();

        JSONObject resultJson = new JSONObject();
        resultJson.put("delay",endTime - startTime);
        resultJson.put("rushToBuyResult",responseJson);
        return resultJson.toJSONString();
    }
    public void commitPrepareTestUser(int count){
        prepareTestUserRunnable.setCount(count);
        PrePareRushToBuyTools.execute(prepareTestUserRunnable,PrePareRushToBuyTools.PREPARE_TEST_USER);
    }

    public void commitPrepareRushToBuyGoods(int count){
        prepareRushToBuyGoodsRunnable.setCount(count);
        PrePareRushToBuyTools.execute(prepareRushToBuyGoodsRunnable,PrePareRushToBuyTools.PREPARE_RUSH_TO_BUY_GOODS);
    }

    public boolean initTestUser(int count){
        int cleanResult = cleanTestUser();
        log.info("Clean records result:" + cleanResult);
        return dataService.initTestUser(count);
    }

    private int cleanTestUser(){
        String url = dbServicesConfigBean.getCleanTestUserMethodUrl();
        JSONObject resultJson = dataService.getDataFromManagerServices(url, DataService.GET_Method_TYPE);
        return JSONAnalysis.analysisForObjectCount(resultJson,"cleanTestUserCount");
    }

    public boolean initRushToBuyGoods(int count){
        return dataService.initRushToBuyGoods(count);
    }


    public long queryRushToBuyGoodsCount(){
        return dataService.queryRushToBuyGoodsCount();
    }

}
