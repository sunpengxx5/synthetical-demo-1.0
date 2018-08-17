package com.huawei.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.Utils.ExceptionProcess;
import com.huawei.Utils.JSONAnalysis;
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

    public String signIn(Map<String, Object> urlVariables){
        String url = dbServicesConfigBean.querySimpleUserInfoUrl();
        JSONObject resultJson;
        try {
            Map<String,Object> dbUrlVariables = new HashMap<>();
            dbUrlVariables.put("userName",urlVariables.get("userName"));
            resultJson = JSONAnalysis.analysisDbJson(dataService.getDataFromDbService( url, dbUrlVariables, DataService.POST_Method_TYPE));

            String userPwd = urlVariables.get("userPwd").toString();
            String dbUserPwd = resultJson.getJSONArray("resMsg").getJSONObject(0).getString("userPwd");

            if(dbUserPwd.equals(userPwd)){
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = resultJson.getJSONArray("resMsg").getJSONObject(0);
                jsonObject.remove("userPwd");
                jsonArray.add(jsonObject);
                resultJson.put("resMsg",jsonArray);
                resultJson.put("signInResult",CommonUtils.SING_IN_SUCCESS);
            }else{
                resultJson.put("resMsg","[]");
                resultJson.put("signInResult",CommonUtils.SING_IN_FAILED);
            }
        }catch (Exception e){
            resultJson = ExceptionProcess.processException(e);
        }
        return resultJson.toJSONString();
    }

    public String userDetail(Map<String, Object> urlVariables){
        String url = dbServicesConfigBean.queryUserDetailInfoByIdUrl();
        JSONObject jsonObject;
        try {
            jsonObject = JSONAnalysis.analysisDbJson(dataService.getDataFromDbService( url, urlVariables, DataService.POST_Method_TYPE));
        }catch (Exception e){
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }

    public String signUp(Map<String, Object> urlVariables){
        String url = dbServicesConfigBean.getAddUserUrl();
        JSONObject jsonObject;
        try {
            jsonObject = JSONAnalysis.analysisDbJson(dataService.getDataFromDbService( url, urlVariables, DataService.POST_Method_TYPE));
        }catch (Exception e){
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }


    public String goodsList(String goodsType){
        String url = dbServicesConfigBean.getQueryGoodsListUrl(goodsType);
        JSONObject jsonObject;
        try {
            jsonObject = JSONAnalysis.analysisDbJson(dataService.getDataFromDbService( url, DataService.GET_Method_TYPE));
        }catch (Exception e){
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }

    public String goodsDetail(String goodsId){
        String url = dbServicesConfigBean.getQueryGoodsDetailUrl(goodsId);
        JSONObject jsonObject;
        try {
            jsonObject = dataService.getDataWithRedis( url,DataService.GET_Method_TYPE,goodsId);
        }catch (Exception e){
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }

    public String orderList( Map<String, Object> urlVariables){
        String url = dbServicesConfigBean.getQueryOrdersListUrl();
        JSONObject jsonObject;
        try {
            jsonObject = JSONAnalysis.analysisDbJson(dataService.getDataFromDbService( url, urlVariables, DataService.POST_Method_TYPE));
        }catch (Exception e){
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }


    public String pay( Map<String, Object> urlVariables){
        JSONObject jsonObject;
        String url = dbServicesConfigBean.getPayUrl();
        try {
            jsonObject = dataService.getDataFromDbService(url, urlVariables, DataService.POST_Method_TYPE);
        } catch (Exception e) {
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }

    public String payPendingPayment( Map<String, Object> urlVariables){
        JSONObject jsonObject;
        String url = dbServicesConfigBean.getPayPendingPaymentMethodUrl();
        try {
            jsonObject = dataService.getDataFromDbService(url, urlVariables, DataService.POST_Method_TYPE);
        } catch (Exception e) {
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }


    public String initRushToBuyGoods(int count){
        JSONObject jsonObject = new JSONObject();
        if(dataService.initRushToBuyGoods(count)){
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            jsonObject.put("resMsg",CommonUtils.SUCCESS);
        }else {
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",CommonUtils.FAILED);
        }
        return jsonObject.toJSONString();
    }

    public String rushToBuy(String userId,String goodsId){
        JSONObject jsonObject = new JSONObject();
        String token = dataService.obtainRushToBuyToken();
        if(token != null){
            log.info("RushToBuy token:" + token);
            JSONObject msgJson = new JSONObject();
            msgJson.put("token",token);
            msgJson.put("userId",userId);
            msgJson.put("goodsId",goodsId);
            boolean sendResult = kafkaManager.produceMsg(msgJson.toJSONString());
            if(sendResult) {
                jsonObject.put("errCode", CommonUtils.NORMAL_CODE);
                jsonObject.put("resMsg", CommonUtils.SUCCESS);
                log.info("Rush to buy success!");
            }else {
                jsonObject.put("errCode",CommonUtils.ERROR_CODE);
                jsonObject.put("resMsg",CommonUtils.FAILED);
                log.error("Rush to buy error:Send msg failed!");
            }
        }else {
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",CommonUtils.FAILED);
            log.info("Rush to buy:Token is null!");
        }
        return jsonObject.toJSONString();
    }

    public String pendingPayment(String userId){
        String url = dbServicesConfigBean.getQueryPendingPaymentMethodUrl(userId);
        JSONObject jsonObject;
        try {
            jsonObject = JSONAnalysis.analysisDbJson(dataService.getDataFromDbService( url, DataService.GET_Method_TYPE));
        }catch (Exception e){
            jsonObject = ExceptionProcess.processException(e);
        }
        return jsonObject.toJSONString();
    }
}
