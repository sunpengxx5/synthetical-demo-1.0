package com.huawei.service;

import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.Utils.JSONAnalysis;
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
    private final static String GOODS_DETAIL = "GoodsDetail";

    public final static String POST_Method_TYPE = "Post";
    public final static String GET_Method_TYPE = "Get";

    private final static String RUSH_TO_BUY_GOODS_TOKEN_QUEUE = "RushToBuyGoodsTokenList";
    private final static String RUSH_TO_BUY_GOODS_TOKEN_PREFIX = "RushToBuyGoodsToken-";

    private final static int ATTEMPT_COUNT = 1;


    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private RedisCacheManager redisCacheManager;


    public JSONObject getDataFromDbService(String url,String methodType){
        return getDataFromDbService( url, null,methodType);
    }
    public JSONObject getDataFromDbService(String url,Map<String, Object> urlVariables,String methodType){
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

    public JSONObject getDataWithRedis(String url,String methodType,String key){
        JSONObject result = getJSONObjectFromRedis(key);
        if(result == null) {
            result = JSONAnalysis.analysisDbJson(getDataFromDbService(url,methodType));
            try {
                redisCacheManager.set(key, result.toJSONString());
            } catch (Exception e) {
                log.error(e);
                e.printStackTrace();
            }
        }
        return result;
    }

    private JSONObject getJSONObjectFromRedis(String key){
        JSONObject jsonObject = null;
        try {
            Object value = redisCacheManager.get(key);
            if (value != null) {
                jsonObject = JSONObject.parseObject(value.toString());
            }
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return jsonObject;
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

    public String obtainRushToBuyToken(){
        return redisCacheManager.lRightPop(RUSH_TO_BUY_GOODS_TOKEN_QUEUE);
    }
}
