package com.huawei.Utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

public class ExceptionProcess {

    private static Logger log = Logger.getLogger(ExceptionProcess.class);

    public static JSONObject processException(Exception e){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errCode",CommonUtils.ERROR_CODE);
        jsonObject.put("resMsg",getExceptionInfo(e));
        return jsonObject;
    }

    public static String getExceptionInfo(Exception e){
        log.error(e);
        e.printStackTrace();
        return e.getCause() + ":" + e.getMessage();
    }
}
