package com.huawei.controller;

import com.huawei.Utils.CommonUtils;
import com.huawei.projo.User;
import com.huawei.service.DbServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class DbServiceController {

    @Autowired
    DbServices dbServices;

    @RequestMapping(value="v1/rest/querySimpleUserInfoByName", method = RequestMethod.POST)
    @ResponseBody
    public String querySimpleUserInfoByName(@RequestBody Map<String, Object> param){
        String userName = param.get("userName").toString();
        return dbServices.querySimpleUserInfoByName(userName);
    }
    @RequestMapping(value="v1/rest/queryUserDetailInfoById", method = RequestMethod.POST)
    @ResponseBody
    public String queryUserDetailInfoById(@RequestBody Map<String, Object> param){
        long userId = Long.parseLong(param.get("userId").toString());
        return dbServices.queryUserDetailInfoById(userId);
    }


    @RequestMapping(value="v1/rest/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody Map<String, Object> param){
        String userName = param.get("userName").toString();
        String userPwd = param.get("userPwd").toString();
        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        return dbServices.addUser(user);
    }

    @RequestMapping(value="v1/rest/queryGoodsDetail", method = RequestMethod.GET)
    @ResponseBody
    public String queryGoodsDetail(HttpServletRequest request){
        long goodsId = Long.parseLong(request.getParameter("goodsId"));
        return dbServices.queryGoodsDetail(goodsId);
    }

    @RequestMapping(value="v1/rest/queryGoodsList", method = RequestMethod.GET)
    @ResponseBody
    public String queryGoodsList(HttpServletRequest request){
        String goodsType = request.getParameter("goodsType");
        return dbServices.queryGoodsList(goodsType);
    }

    @RequestMapping(value="v1/rest/queryOrdersList", method = RequestMethod.POST)
    @ResponseBody
    public String queryOrdersList(@RequestBody Map<String, Object> param){
        long userId = Long.parseLong(param.get("userId").toString());
        return dbServices.queryOrdersList(userId);
    }

    @RequestMapping(value="v1/rest/pay", method = RequestMethod.POST)
    @ResponseBody
    public String pay(@RequestBody Map<String, Object> param){
        long userId = Long.parseLong(param.get("userId").toString());
        long goodsId = Long.parseLong(param.get("goodsId").toString());
        int goodsPrice = Integer.parseInt(param.get("goodsPrice").toString());
        return dbServices.pay(userId,goodsId,goodsPrice);
    }

    @RequestMapping(value="v1/rest/payPendingPayment", method = RequestMethod.POST)
    @ResponseBody
    public String payPendingPayment(@RequestBody Map<String, Object> param){
        int ordersId = Integer.parseInt(param.get("ordersId").toString());
        long userId = Long.parseLong(param.get("userId").toString());
        long goodsId = Long.parseLong(param.get("goodsId").toString());
        int goodsPrice = Integer.parseInt(param.get("goodsPrice").toString());
        return dbServices.payPendingPayment(ordersId,userId,goodsId,goodsPrice);
    }

    @RequestMapping(value="v1/rest/queryBalance", method = RequestMethod.POST)
    @ResponseBody
    public String queryBalance(@RequestBody Map<String, Object> param){
        long userId = Long.parseLong(param.get("userId").toString());
        return dbServices.queryUserBalance(userId);
    }

    @RequestMapping(value="v1/rest/queryGoodsCount", method = RequestMethod.GET)
    @ResponseBody
    public String queryGoodsCount( HttpServletRequest request){
        long goodsId = Long.parseLong(request.getParameter("goodsId"));
        return dbServices.queryGoodsCount(goodsId);
    }
}
