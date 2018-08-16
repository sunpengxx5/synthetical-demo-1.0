package com.huawei;

import com.huawei.service.ConsoleBackstageService;
import com.huawei.tools.PrePareRushToBuyTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class DemoTest {
    @Autowired
    ConsoleBackstageService consoleBackstageService;
    @Test
    public void test(){
        String result=null;
        int rushToBuyGoodsCount = 10;
        int rushToBuyUsersCount = 10;
        if(PrePareRushToBuyTools.getPrivilegeOfCommitData(PrePareRushToBuyTools.PREPARE_TEST_USER)) {
            consoleBackstageService.commitPrepareTestUser(rushToBuyUsersCount);
        }else {
            result = "Please do not repeat the submission!";
        }
    }

    @Test
    public void testFutureTask(){
        FutureTask<String > task=new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
    }

    @Test
    public void testProduceKafkaMsg(){
    }

    @Test
    public void testGetMsgAmount(){
    }

    @Test
    public void testResetKafkaQueueMessages(){
    }
}
