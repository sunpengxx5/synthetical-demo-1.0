package com.huawei.service;

import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.Utils.JSONAnalysis;
import com.huawei.bean.ManagerServicesConfigBean;
import com.huawei.projo.Goods;
import com.huawei.projo.PendingPaymentOrders;
import com.huawei.projo.Orders;
import com.huawei.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dataSourcesService")
public class DataSourcesService {

    @Autowired
    private ManagerServicesConfigBean managerServicesConfigBean;

    @Autowired
    private HttpClientService httpClientService;

    public List<Goods> getNorMalGoodsList(){
        String url = managerServicesConfigBean.getGoodsListMethodUrl(CommonUtils.GOODS_TYPE_NORMAL);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        return JSONAnalysis.analysisGoodsList(resultJson);
    }

    public Goods getRushToBuyGoodsList(){
        String url = managerServicesConfigBean.getGoodsListMethodUrl(CommonUtils.GOODS_TYPE_RUSH_TO_BUY);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        return JSONAnalysis.analysisRushToBuyGoodsList(resultJson);
    }

    public Goods getGoodsDetail(String goodsId){
        String url = managerServicesConfigBean.getGoodsDetailMethodUrl(goodsId);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        return JSONAnalysis.analysisGoodsDetail(resultJson);
    }

    public String signInAndUp(HttpServletRequest request, String type){
        String userName = request.getParameter("username");
        String userPwd = request.getParameter("password");
        User user = signInAndUp(userName,userPwd,type);
        if(user !=  null){
            request.getSession().setAttribute("userId",user.getUserId());
            request.getSession().setAttribute("userName",user.getUserName());
            return "success";
        }else {
            return "failed";
        }
    }

    private User signInAndUp(String userName,String userPwd,String type){
        String url;
        if(type.equals(CommonUtils.SIGN_IN)) {
            url = managerServicesConfigBean.getSignInMethodUrl();
        }else {
            url = managerServicesConfigBean.getSignUpMethodUrl();
        }
        Map<String,Object>  map = new HashMap<>();
        map.put("userName",userName);
        map.put("userPwd",userPwd);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);
        if(type.equals(CommonUtils.SIGN_IN)) {
            return JSONAnalysis.analysisSimpleUser(resultJson, CommonUtils.SIGN_IN);
        }
        else {
            return JSONAnalysis.analysisSimpleUser(resultJson, CommonUtils.SIGN_UP);
        }
    }

    public String pay(String userId,String goodsId,String goodsPrice){
        String result = CommonUtils.PAY_FAILED;
        String url = managerServicesConfigBean.getPayMethodUrl();
        Map<String,Object>  map = new HashMap<>();
        map.put("userId",userId);
        map.put("goodsId",goodsId);
        map.put("goodsPrice",goodsPrice);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);
        if (resultJson != null&&resultJson.getString("errCode")!=null){
            if(resultJson.getString("resMsg").equals(CommonUtils.PAY_SUCCESS)){
                result = CommonUtils.PAY_SUCCESS;
            }
        }
        return result;
    }

    public String payPendingPayment(String ordersId,String userId,String goodsId,String goodsPrice){
        String result = CommonUtils.PAY_FAILED;
        String url = managerServicesConfigBean.getPayPendingPaymentMethod();
        Map<String,Object>  map = new HashMap<>();
        map.put("userId",userId);
        map.put("goodsId",goodsId);
        map.put("goodsPrice",goodsPrice);
        map.put("ordersId",ordersId);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);
        if (resultJson != null&&resultJson.getString("errCode")!=null){
            if(resultJson.getString("resMsg").equals(CommonUtils.PAY_SUCCESS)){
                result = CommonUtils.PAY_SUCCESS;
            }
        }
        return result;
    }

    public List<Orders>  ordersList(String userId){
        String url = managerServicesConfigBean.getOrderListMethodUrl();
        Map<String,Object>  map = new HashMap<>();
        map.put("userId",userId);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);

        return JSONAnalysis.analysisOrdersList(resultJson);
    }

    public User userDetail(String userId){
        String url = managerServicesConfigBean.getUserDetailMethodUrl();
        Map<String,Object>  map = new HashMap<>();
        map.put("userId",userId);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);

        return JSONAnalysis.analysisUserDetail(resultJson);
    }

    public List<PendingPaymentOrders> pendingPaymentOrders(String userId){
        String url=managerServicesConfigBean.getPendingPaymentMethodUrl(userId);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        List<PendingPaymentOrders> pendingPaymentOrdersList =JSONAnalysis.analysisGoodsInCart(resultJson);
        return pendingPaymentOrdersList;
    }

    public boolean rushToBuyGoods(String userId,String goodsId){

        String url = managerServicesConfigBean.getRushToBuyMethodUrl();
        Map<String,Object>  map = new HashMap<>();
        map.put("userId",userId);
        map.put("goodsId",goodsId);

        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);

        return JSONAnalysis.analysisRushToBuyResponse(resultJson);
    }


}
