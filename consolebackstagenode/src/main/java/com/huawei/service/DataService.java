package com.huawei.service;

import com.alibaba.fastjson.JSONObject;
import com.huawei.configbean.DbServicesConfigBean;
import com.huawei.manager.RedisCacheManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Map;

@Service
public class DataService {

    private static Logger log = Logger.getLogger(DataService.class);

    private static final int SPLIT = 5;

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Autowired
    private DbServicesConfigBean dbServicesConfigBean;


    public final static String POST_Method_TYPE = "Post";
    public final static String GET_Method_TYPE = "Get";

    private final static String RUSH_TO_BUY_GOODS_TOKEN_QUEUE = "RushToBuyGoodsTokenList";
    private final static String RUSH_TO_BUY_GOODS_TOKEN_PREFIX = "RushToBuyGoodsToken-";


    public JSONObject getDataFromManagerServices(String url, String methodType){
        return getDataFromManagerServices(url,null,methodType);
    }

    public JSONObject getDataFromManagerServices(String url, Map<String, Object> urlVariables, String methodType){
        JSONObject result = null;
        try {
            if (methodType.equals(POST_Method_TYPE)) {
                result = restTemplate.postForObject(url, urlVariables, JSONObject.class);
            } else {
                result = restTemplate.getForObject(url, JSONObject.class);
            }
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return result;
    }


    public boolean initTestUser(int count){
        boolean result = false;
        try {
            String url = dbServicesConfigBean.getAddTestUserMethodUrl(5);
            for (int i = 0; i < count / SPLIT; i++) {
                getDataFromManagerServices(url, GET_Method_TYPE);
            }
            url = dbServicesConfigBean.getAddTestUserMethodUrl(count % 5);
            getDataFromManagerServices(url, GET_Method_TYPE);
            result = true;
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return result;
    }

    public boolean initRushToBuyGoods(int count){

        boolean result = false;
        DecimalFormat df = new DecimalFormat("0000");
        try {
            redisCacheManager.del(RUSH_TO_BUY_GOODS_TOKEN_QUEUE);
            for(int i = 0;i < count;i++){
                redisCacheManager.lSet(RUSH_TO_BUY_GOODS_TOKEN_QUEUE,RUSH_TO_BUY_GOODS_TOKEN_PREFIX + df.format(i));
            }
            result = true;
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }

        return result;
    }

    public long queryRushToBuyGoodsCount(){
        long goodsCount = -1;
        try{
            goodsCount = redisCacheManager.lGetListSize(RUSH_TO_BUY_GOODS_TOKEN_QUEUE);
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return goodsCount;
    }

}
