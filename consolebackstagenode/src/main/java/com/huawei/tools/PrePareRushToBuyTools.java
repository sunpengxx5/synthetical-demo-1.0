package com.huawei.tools;

import com.huawei.Utils.CommonUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrePareRushToBuyTools {

    public static String PREPARE_TEST_USER = "TestUser";
    public static String PREPARE_RUSH_TO_BUY_GOODS = "RushToBuyGoods";

    private static final int THREAD_NUM = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);


    private static int commitFlagTestUser = 0;
    private static int commitSuccessTestUser = 0;
    private static int executeTaskCountOfTestUser = 0;

    private static int commitFlagRushToBuyGoods = 0;
    private static int commitSuccessRushToBuyGoods = 0;
    private static int executeTaskCountOfRushToBuyGoods = 0;
    
    public static void execute(Runnable runnable,String type){
        synchronized (PrePareRushToBuyTools.class){
            if(type.equals(PREPARE_TEST_USER)) {
                executeTaskCountOfTestUser++;
            }else if (type.equals(PREPARE_RUSH_TO_BUY_GOODS)){
                executeTaskCountOfRushToBuyGoods++;
            }
        }
        executorService.execute(runnable);
    }

    public static boolean getPrivilegeOfCommitData(String type){
        synchronized (PrePareRushToBuyTools.class){
            if(type.equals(PREPARE_TEST_USER)) {
                if (commitFlagTestUser == 0) {
                    commitFlagTestUser = 1;
                    return true;
                }
            }else if (type.equals(PREPARE_RUSH_TO_BUY_GOODS)) {
                if (commitFlagRushToBuyGoods == 0) {
                    commitFlagRushToBuyGoods = 1;
                    return true;
                }
            }
        }
        return false;
    }
    public static void resetPrivilegeOfCommitData(String type){
        synchronized (PrePareRushToBuyTools.class){
            if(type.equals(PREPARE_TEST_USER)) {
                commitSuccessTestUser++;
                if (commitSuccessTestUser >= executeTaskCountOfTestUser) {
                    commitFlagTestUser = 0;
                    commitSuccessTestUser = 0;
                    executeTaskCountOfTestUser = 0;
                }
            }else if (type.equals(PREPARE_RUSH_TO_BUY_GOODS)) {
                commitSuccessRushToBuyGoods++;
                if (commitSuccessRushToBuyGoods >= executeTaskCountOfRushToBuyGoods) {
                    commitFlagRushToBuyGoods = 0;
                    commitSuccessRushToBuyGoods = 0;
                    executeTaskCountOfRushToBuyGoods = 0;
                }
            }
        }
    }
}
