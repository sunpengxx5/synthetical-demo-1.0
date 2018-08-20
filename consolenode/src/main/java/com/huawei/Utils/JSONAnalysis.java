package com.huawei.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.projo.Goods;
import com.huawei.projo.Orders;
import com.huawei.projo.PendingPaymentOrders;
import com.huawei.projo.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JSONAnalysis {

    private static Logger log = Logger.getLogger(JSONAnalysis.class);


    public static List<Goods> analysisGoodsList(JSONObject jsonObject){
        List<Goods> goodsList = new LinkedList<>();
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null){
                for(int i=0;i<jsonArray.size();i++) {
                    goodsList.add(Goods.jsonToSimpleGoods(jsonArray.getJSONObject(i)));
                }
            }
        }
        return goodsList;
    }
    public static Goods analysisRushToBuyGoodsList(JSONObject jsonObject){
        Goods goods = null;
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null && jsonArray.size() > 0){
                goods = Goods.jsonToSimpleGoods(jsonArray.getJSONObject(0));
            }
        }
        return goods;
    }
    public static Goods analysisGoodsDetail(JSONObject jsonObject){
        Goods goods = null;
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null){
                if(jsonArray != null && jsonArray.size() > 0){
                    goods = Goods.jsonToDetailGoods(jsonArray.getJSONObject(0));
                }
            }
        }
        return goods;
    }

    public static User analysisSimpleUser(JSONObject jsonObject,String type){
        if(type.equals(CommonUtils.SIGN_IN)){
            return analysisSimpleUserForSignIn(jsonObject);
        }else {
            return analysisSimpleUserForSignUp(jsonObject);
        }
    }

    private static User analysisSimpleUserForSignIn(JSONObject jsonObject){
        User user = null;
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)) {
            if(jsonObject.getString("signInResult")!=null &&
                    jsonObject.getString("signInResult").equals(CommonUtils.SIGN_IN_SUCCESS)){
                JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
                if(jsonArray != null && jsonArray.size() > 0){
                    user = User.jsonToSimpleUser(jsonArray.getJSONObject(0));
                }
            }
        }
        return user;
    }

    private static User analysisSimpleUserForSignUp(JSONObject jsonObject){
        User user = null;
        if(jsonObject != null && jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)) {
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null && jsonArray.size() > 0){
                user = User.jsonToSimpleUser(jsonArray.getJSONObject(0));
            }
        }
        return user;
    }

    public static List<Orders> analysisOrdersList(JSONObject jsonObject){
        List<Orders> ordersList = new LinkedList<>();
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null){
                for(int i=0;i<jsonArray.size();i++) {
                    ordersList.add(Orders.jsonToOrders(jsonArray.getJSONObject(i)));
                }
            }
        }
        return ordersList;
    }

    public static User analysisUserDetail(JSONObject jsonObject){
        User user = null;
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null){
                for(int i=0;i<jsonArray.size();i++) {
                    user = User.jsonToDetailUser(jsonArray.getJSONObject(0));
                }
            }
        }
        return user;
    }

    public static boolean analysisRushToBuyResponse(JSONObject resJson){
        boolean result = false;
        if(resJson != null &&  resJson.getString("errCode") != null &&
                resJson.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            if(resJson.getString("resMsg") != null && resJson.getString("resMsg").equals("Success")){
                result = true;
            }
        }
        return  result;
    }

    //Below is Lizhi's part
    public static List<PendingPaymentOrders> analysisGoodsInCart(JSONObject jsonObject){
        List<PendingPaymentOrders> pendingPaymentOrdersList =new ArrayList<PendingPaymentOrders>();
        if(jsonObject != null &&  jsonObject.getString("errCode") != null &&
                jsonObject.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            JSONArray jsonArray = jsonObject.getJSONArray("resMsg");
            if(jsonArray != null){
                for(int i=0;i<jsonArray.size();i++) {
                 PendingPaymentOrders temp=PendingPaymentOrders.jsonToGoodsInCart(jsonArray.getJSONObject(i));
                 pendingPaymentOrdersList.add(temp);
                }
            }
        }
        return pendingPaymentOrdersList;
    }

    public static int analysisGoodsCounts(JSONObject resJson){
        int result = -1;
        if(resJson != null &&  resJson.getString("errCode") != null &&
                resJson.getString("errCode").equals(CommonUtils.MANAGER_SERVICES_NORMAL_CODE)){
            if(resJson.getString("resMsg") != null){
                try {
                    result = resJson.getIntValue("resMsg");
                }catch (Exception e){
                    log.error(e);
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }

}
