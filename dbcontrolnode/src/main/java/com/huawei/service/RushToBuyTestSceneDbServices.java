package com.huawei.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.Utils.ExceptionProcess;
import com.huawei.dao.OrdersDao;
import com.huawei.dao.PendingPaymentOrdersDao;
import com.huawei.dao.UserDao;
import com.huawei.projo.PendingPaymentOrders;
import com.huawei.projo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RushToBuyTestSceneDbServices {
    private static Logger log = Logger.getLogger(DbServices.class);

    @Resource
    private UserDao userDao;

    @Resource
    private OrdersDao ordersDao;

    @Resource
    private PendingPaymentOrdersDao pendingPaymentOrdersDao;

    public String addTestUser(int count){
        JSONObject jsonObject = new JSONObject();
        try {
            int result = 0;
            for(int i=0;i<count;i++) {
                result += userDao.addUser("test" + System.currentTimeMillis() + i,"123",CommonUtils.USER_TEST_TYPE);
            }
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            JSONArray jsonArray = new JSONArray();
            JSONObject resultJson = new JSONObject();
            resultJson.put("testUserCount",result);
            jsonArray.add(resultJson);
            jsonObject.put("resMsg",jsonArray);
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String queryTestUser(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<User> userList = userDao.queryUser(CommonUtils.USER_TEST_TYPE);
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            jsonObject.put("resMsg",User.toJsonArray(userList));
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String queryTestUserCount(){
        JSONObject jsonObject = new JSONObject();
        try {
            int result = userDao.queryUserCount(CommonUtils.USER_TEST_TYPE);
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            JSONArray jsonArray = new JSONArray();
            JSONObject resultJson = new JSONObject();
            resultJson.put("testUserCount",result);
            jsonArray.add(resultJson);
            jsonObject.put("resMsg",jsonArray);
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String cleanTestUser(){
        JSONObject jsonObject = new JSONObject();
        try {
            int result = userDao.cleanUser(CommonUtils.USER_TEST_TYPE);
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            JSONArray jsonArray = new JSONArray();
            JSONObject resultJson = new JSONObject();
            resultJson.put("cleanTestUserCount",result);
            jsonArray.add(resultJson);
            jsonObject.put("resMsg",jsonArray);
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String queryRushToBuySuccessCount(){
        JSONObject jsonObject = new JSONObject();
        try {
            int result = ordersDao.queryRushToBuySuccessCount(CommonUtils.USER_TEST_TYPE,CommonUtils.DEFAULT_VALUE);
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            JSONArray jsonArray = new JSONArray();
            JSONObject resultJson = new JSONObject();
            resultJson.put("queryRushToBuySuccessCount",result);
            jsonArray.add(resultJson);
            jsonObject.put("resMsg",jsonArray);
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String queryRushToBuySuccessUser(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<User> userList = ordersDao.queryRushToBuySuccessUser(CommonUtils.USER_TEST_TYPE,CommonUtils.DEFAULT_VALUE);
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            jsonObject.put("resMsg",User.toJsonArray(userList));
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String queryTestUserIdRange(){
        JSONObject jsonObject = new JSONObject();
        try {
            int minId = userDao.queryUserMinId(CommonUtils.USER_TEST_TYPE);
            int maxId = userDao.queryUserMaxId(CommonUtils.USER_TEST_TYPE);
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            JSONArray jsonArray = new JSONArray();
            JSONObject resultJson = new JSONObject();
            resultJson.put("testUserIdRange","[" + minId + "," + maxId +"]");
            jsonArray.add(resultJson);
            jsonObject.put("resMsg",jsonArray);
        }catch (Exception e){
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return jsonObject.toJSONString();
    }

    public String batchAddPendingPayment(String pendingPaymentJsonArrayStr){
        JSONObject resultJson = new JSONObject();
        try {
            List<PendingPaymentOrders> pendingPaymentOrdersList = PendingPaymentOrders.jsonArrayToList(pendingPaymentJsonArrayStr);
            int result = pendingPaymentOrdersDao.batchAdd(pendingPaymentOrdersList);

            resultJson.put("errCode", CommonUtils.NORMAL_CODE);

            JSONArray jsonArray = new JSONArray();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("addCount", result);

            jsonArray.add(jsonObject);

            resultJson.put("resMsg", jsonArray);

            log.info("batchAddPendingPayment:Add count " + result);
        }catch (Exception e){
            resultJson.put("errCode",CommonUtils.ERROR_CODE);
            resultJson.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }
        return resultJson.toJSONString();
    }

    public String queryPendingPayment(long userId){
        JSONObject resultJson = new JSONObject();

        try {
            List<PendingPaymentOrders> pendingPaymentOrdersList = pendingPaymentOrdersDao.queryPendingPaymentOrders(userId);
            resultJson.put("errCode", CommonUtils.NORMAL_CODE);
            resultJson.put("resMsg",JSONArray.parseArray(pendingPaymentOrdersList.toString()));

        }catch (Exception e){
            resultJson.put("errCode",CommonUtils.ERROR_CODE);
            resultJson.put("resMsg",ExceptionProcess.getExceptionInfo(e));
        }

        return resultJson.toJSONString();
    }

}
