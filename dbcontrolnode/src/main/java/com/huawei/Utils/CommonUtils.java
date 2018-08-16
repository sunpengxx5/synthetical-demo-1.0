package com.huawei.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public final static String NORMAL_CODE = "DbService.200";
    public final static String ERROR_CODE = "DbService.400";


    public final static String NOT_SUFFICIENT_FUNDS = "NotSufficientFunds";
    public final static String PAY_SUCCESS = "PaySuccess";
    public final static String  LACK_OF_STOCK = "LackOfStock";

    public final static String GOODS_TYPE_NORMAL = "NORMAL";
    public final static String  GOODS_TYPE_RUSH_TO_BUY = "RushToBuy";

    public final static String  DEFAULT_VALUE = "-";

    public final static String USER_TEST_TYPE = "test";


    public static String getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
