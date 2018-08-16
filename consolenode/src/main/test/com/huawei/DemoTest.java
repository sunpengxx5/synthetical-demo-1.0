package com.huawei;

import com.huawei.projo.PendingPaymentOrders;
import com.huawei.bean.ManagerServicesConfigBean;
import com.huawei.projo.Goods;
import com.huawei.service.DataSourcesService;
import com.huawei.service.HttpClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class DemoTest {

    @Autowired
    private ManagerServicesConfigBean managerServicesConfigBean;

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    DataSourcesService dataSourcesService;

    @Test
    public void goodsTest(){
        Goods goods = dataSourcesService.getGoodsDetail("1");
        System.out.println(goods.toString());
    }


    @Test
    public void testSignUp(){
}

    @Test
    public void payTest(){
        String result = dataSourcesService.pay("1","1","2");
        System.out.println(result);
    }
    @Test
    public void TestCart(){
        List<PendingPaymentOrders> pendingPaymentOrdersList =dataSourcesService.pendingPaymentOrders("1");
        for(int i = 0; i!= pendingPaymentOrdersList.size(); ++i){
            System.out.println(pendingPaymentOrdersList.get(i).toString());
        }
    }

    @Test
    public void testRushToBuy(){
        System.out.println(dataSourcesService.rushToBuyGoods("2","5"));
    }

    @Test
    public void pendingPaymentTest(){
        String result = dataSourcesService.payPendingPayment("262","87456","5","2");
        System.out.println(result);
    }


}
