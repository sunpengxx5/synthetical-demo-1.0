package com.huawei.controller;

import com.huawei.Utils.CommonUtils;
import com.huawei.bean.ConsoleBackStageConfigBean;
import com.huawei.projo.Goods;
import com.huawei.projo.PendingPaymentOrders;
import com.huawei.projo.Orders;
import com.huawei.projo.User;
import com.huawei.service.DataSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    DataSourcesService dataSourcesService;

    @Autowired
    ConsoleBackStageConfigBean consoleBackStageConfigBean;

    @RequestMapping(value="sign", method = RequestMethod.GET)
    public String sign(){
        return "com/sign";
    }

    @RequestMapping(value="signIn", method = RequestMethod.POST)
    @ResponseBody
    public String signIn(HttpServletRequest request){
        return dataSourcesService.signInAndUp(request,CommonUtils.SIGN_IN);
    }

    @RequestMapping(value="signUp", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(HttpServletRequest request){
        return dataSourcesService.signInAndUp(request,CommonUtils.SIGN_UP);
    }

    @RequestMapping(value="signOut", method = RequestMethod.GET)
    @ResponseBody
    public String signOut(HttpServletRequest request){
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userName");
        return "SignOutSuccess";
    }

    @RequestMapping(value="mall", method = RequestMethod.GET)
    public String mall(HttpServletRequest request){
        List<Goods> goodsList = dataSourcesService.getNorMalGoodsList();
        Goods rushToBuyGoods = dataSourcesService.getRushToBuyGoodsList();
        request.setAttribute("goodsList",goodsList);
        request.setAttribute("rushToBuyGoods",rushToBuyGoods);
        request.getSession().setAttribute("rushToBuyScene",consoleBackStageConfigBean.getRushToBuySceneURL());
        return "com/mall";
    }

    @RequestMapping(value="goodsDetail", method = RequestMethod.GET)
    public String normalGoodsDetail(HttpServletRequest request){
        String goodsId = request.getParameter("goodsId");
        Goods goods = dataSourcesService.getGoodsDetail(goodsId);
        request.setAttribute("goods",goods);
        return "com/goodsDetail";
    }

    @RequestMapping(value="payPage", method = RequestMethod.POST)
    public String payNormalGoods(HttpServletRequest request){
        String goodsId = request.getParameter("goodsId");
        Goods goods = dataSourcesService.getGoodsDetail(goodsId);
        request.setAttribute("goods",goods);
        return "com/pay";
    }

    @RequestMapping(value="rushToBuy", method = RequestMethod.POST)
    @ResponseBody
    public String rushToBuy(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");
        String result = "Failed";

        boolean rushToBuyResult = dataSourcesService.rushToBuyGoods(userId,goodsId);

        if(rushToBuyResult) {
            List<PendingPaymentOrders> pendingPaymentOrdersList =dataSourcesService.pendingPaymentOrders(userId);
            request.setAttribute("pendingPaymentOrdersList", pendingPaymentOrdersList);
            result = "Success";
        }
        return result;
    }

    @RequestMapping(value="pendingPaymentOrders", method = RequestMethod.GET)
    public String pendingPaymentOrders(HttpServletRequest request){
        String userId = request.getParameter("userId");
        List<PendingPaymentOrders> pendingPaymentOrdersList =dataSourcesService.pendingPaymentOrders(userId);
        request.setAttribute("pendingPaymentOrdersList", pendingPaymentOrdersList);
        request.setAttribute("goodsInCartListSize", pendingPaymentOrdersList.size());
        return "com/pendingPaymentOrders";
    }

    @RequestMapping(value="pay", method = RequestMethod.POST)
    @ResponseBody
    public String normalPay(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");
        String goodsPrice = request.getParameter("goodsPrice");
        return dataSourcesService.pay(userId,goodsId,goodsPrice);
    }

    @RequestMapping(value="payPendingPayment", method = RequestMethod.POST)
    @ResponseBody
    public String payPendingPayment(HttpServletRequest request){
        String ordersId = request.getParameter("ordersId");
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");
        String goodsPrice = request.getParameter("goodsPrice");

        return dataSourcesService.payPendingPayment(ordersId,userId,goodsId,goodsPrice);
    }

    @RequestMapping(value="orders", method = RequestMethod.GET)
    public String orders(HttpServletRequest request){
        String userId = request.getParameter("userId");
        List<Orders> ordersList = dataSourcesService.ordersList(userId);
        request.setAttribute("ordersList",ordersList);
        request.setAttribute("ordersListSize",ordersList.size());
        return "com/orders";
    }

    @RequestMapping(value="userDetail", method = RequestMethod.GET)
    public String userDetail(HttpServletRequest request){
        String userId = request.getParameter("userId");
        User user =dataSourcesService.userDetail(userId);
        request.setAttribute("user",user);
        return "com/userDetail";
    }

    @RequestMapping(value="rushToBuyFailed", method = RequestMethod.GET)
    public String rushToBuyFailed(){
        return "com/rushToBuyFailed";
    }

}
