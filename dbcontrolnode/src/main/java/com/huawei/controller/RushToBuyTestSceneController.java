package com.huawei.controller;

import com.huawei.service.RushToBuyTestSceneDbServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
//@RequestMapping("/rushToBusyTest")
public class RushToBuyTestSceneController {

    @Autowired
    RushToBuyTestSceneDbServices rushToBuyTestSceneDbServices;

    @RequestMapping(value="v1/rest/addTestUser", method = RequestMethod.GET)
    @ResponseBody
    public String addTestUser(HttpServletRequest request){
        int count = Integer.parseInt(request.getParameter("count"));
        return rushToBuyTestSceneDbServices.addTestUser(count);
    }

    @RequestMapping(value="v1/rest/queryTestUser", method = RequestMethod.GET)
    @ResponseBody
    public String queryTestUser(){
        return rushToBuyTestSceneDbServices.queryTestUser();
    }

    @RequestMapping(value="v1/rest/queryTestUserCount", method = RequestMethod.GET)
    @ResponseBody
    public String queryTestUserCount(){
        return rushToBuyTestSceneDbServices.queryTestUserCount();
    }

    @RequestMapping(value="v1/rest/cleanTestUser", method = RequestMethod.GET)
    @ResponseBody
    public String cleanTestUser(){
        return rushToBuyTestSceneDbServices.cleanTestUser();
    }


    @RequestMapping(value="v1/rest/queryRushToBuySuccessUser", method = RequestMethod.GET)
    @ResponseBody
    public String queryRushToBuySuccessUser(){
        return rushToBuyTestSceneDbServices.queryRushToBuySuccessUser();
    }

    @RequestMapping(value="v1/rest/queryRushToBuySuccessCount", method = RequestMethod.GET)
    @ResponseBody
    public String queryRushToBuySuccessCount(){
        return rushToBuyTestSceneDbServices.queryRushToBuySuccessCount();
    }

    @RequestMapping(value="v1/rest/queryTestUserIdRange", method = RequestMethod.GET)
    @ResponseBody
    public String queryTestUserIdRange(){
        return rushToBuyTestSceneDbServices.queryTestUserIdRange();
    }

    @RequestMapping(value="v1/rest/batchAddPendingPayment", method = RequestMethod.POST)
    @ResponseBody
    public String batchAddPendingPayment(@RequestBody Map<String, Object> param){
        String pendingPayments = param.get("pendingPayments").toString();
        return rushToBuyTestSceneDbServices.batchAddPendingPayment(pendingPayments);
    }

    @RequestMapping(value="v1/rest/queryPendingPayment", method = RequestMethod.GET)
    @ResponseBody
    public String queryPendingPayment(HttpServletRequest request){
        long userId = Long.parseLong(request.getParameter("userId"));
        return rushToBuyTestSceneDbServices.queryPendingPayment(userId);
    }

}