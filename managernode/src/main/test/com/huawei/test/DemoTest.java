package com.huawei.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.configbean.DbServicesConfigBean;
import com.huawei.manager.KafkaManager;
import com.huawei.manager.RedisCacheManager;
import com.huawei.service.DataService;
import com.huawei.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/config/spring/*.xml"})
public class DemoTest {

    @Autowired
    RedisCacheManager redisCacheManager;


    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void RedisTest(){
        System.out.println("Test");
        System.out.println("get sun:" + redisCacheManager.hasKey("sun"));
        System.out.println("get peng:" + redisCacheManager.hasKey("peng"));
        redisCacheManager.set("sunpeng","xxxxxx");
        System.out.println("get sunpeng:" + redisCacheManager.get("sunpeng"));
        System.out.println("get peng:" + redisCacheManager.get("peng"));
//        WebClient
    }

    @Test
    public void WebTest(){
        Map<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("userName","sunpeng");
        urlVariables.put("password","pengsun");
        String url = "http://localhost:8080/v1/rest/signIn";
        JSONObject result = restTemplate.postForObject(url,urlVariables,JSONObject.class);

//        JSONObject result = restTemplate.getForObject(url,JSONObject.class, urlVariables);
        System.out.println(result.toJSONString());
    }
    @Autowired
    ManagerService managerService;
    @Test
    public void testSignIn(){
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("userName","tom1");
        urlVariables.put("userPwd","tom1");
        System.out.println( managerService.signIn(urlVariables));
    }

    @Test
    public void testSignUp(){
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("userName","tom12");
        urlVariables.put("userPwd","tom");
        System.out.println( managerService.signUp(urlVariables));
    }
    @Test
    public void testGoodsList(){
        System.out.println( managerService.goodsList("Normal"));
    }

    @Test
    public void testGoodsDetailOnRushToBuy(){
        System.out.println( managerService.goodsDetail("2"));
    }

    @Test
    public void testGoodsDetailOnNormal(){
        System.out.println( managerService.goodsDetail("2"));
    }

    @Test
    public void testPayOnNormal(){
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("userId","1");
        urlVariables.put("goodsId","1");
        urlVariables.put("goodsPrice","2");
        urlVariables.put("goodsType","Normal");
//        System.out.println( managerService.pay(urlVariables));
    }

    @Test
    public void testPayOnRushToBuy(){
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("userId","1");
        urlVariables.put("goodsId","1");
        urlVariables.put("goodsPrice","2");
        urlVariables.put("goodsType","RushToBuy");
//        System.out.println( managerService.pay(urlVariables));
    }
    @Test
    public void testOrdersList() {
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("userId", "1");
        System.out.println(managerService.orderList(urlVariables));
    }

    @Autowired
    KafkaManager kafkaManager;
    @Test
    public void testConsumer() {
//        kafkaManager.consumeMsg(200);
    }


    @Test
    public void testString(){
        redisCacheManager.set("test","1");
        System.out.println(redisCacheManager.get("test"));
        System.out.println(redisCacheManager.incr("test",1));
        System.out.println(redisCacheManager.incr("test",1));
        System.out.println(redisCacheManager.incr("test",1));
        System.out.println(redisCacheManager.incr("test",1));
    }

    @Test
    public void testList(){
        System.out.println(managerService.initRushToBuyGoods(5));
    }

    @Test
    public void test(){
//        managerService.recordRushToBuyOrders(500);
////        for(int i = 0;i < 200;i++){
////            JSONObject jsonObject =new JSONObject();
////            managerService.rushToBuy("1","1");
////        }
    }


    @Test
    public void testRushToBuy(){
        System.out.println(managerService.rushToBuy("1","5"));
    }

    @Autowired
    private DataService dataService;
    @Autowired
    private DbServicesConfigBean dbServicesConfigBean;

    @Test
    public void testAddBatch(){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<5;i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId",i);
            jsonObject.put("goodsId",i);
            jsonObject.put("token","token"+i);
            jsonArray.add(jsonObject);
        }
        if( jsonArray.size() > 0 ){
            String url = dbServicesConfigBean.getBatchAddPendingPaymentMethodUrl();
            Map<String,Object> urlVariables = new HashMap<>();
            urlVariables.put("pendingPayments",jsonArray.toJSONString());
            JSONObject resultJson = dataService.getDataFromDbService( url, urlVariables, DataService.POST_Method_TYPE);
            System.out.println(resultJson.toJSONString());
        }
    }

}
