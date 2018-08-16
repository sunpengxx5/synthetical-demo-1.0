package com.huawei.test;

import com.huawei.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/config/spring/*.xml"})
public class DemoTest {

    @Autowired
    ManagerService managerService;



    @Test
    public void test(){
        managerService.recordRushToBuyOrders(500);
//        for(int i = 0;i < 200;i++){
//            JSONObject jsonObject =new JSONObject();
//            managerService.rushToBuy("1","1");
//        }
    }

}
