package com.huawei.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

public class JSONAnalysis {

    private static Logger log = Logger.getLogger(JSONAnalysis.class);

    public static int analysisForObjectCount(JSONObject jsonObject,String key){
        int result = -1;
        try {
            JSONObject resMsgJson = JsonObjectAnalysis(jsonObject);
            if(resMsgJson != null && resMsgJson.getString(key) != null){
                result = Integer.parseInt(resMsgJson.getString(key));
            }
        }catch (Exception e){
            result = -1;
            log.error(e);
            e.printStackTrace();
        }
        return result;
    }

    public static String analysisObjectString(JSONObject jsonObject ,String key){
        String result = "";
        try {
            JSONObject resMsgJson = JsonObjectAnalysis(jsonObject);
            if(resMsgJson != null && resMsgJson.getString(key) != null){
                result = resMsgJson.getString(key);
            }
        }catch (Exception e){
            result = "";
            log.error(e);
            e.printStackTrace();
        }
        return result;
    }

    public static JSONObject analysisObjectJson(JSONObject jsonObject){
        JSONObject resMsgJson = null;
        try {
            resMsgJson = JsonObjectAnalysis(jsonObject);
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return resMsgJson;
    }


    private static JSONArray commonAnalysis(JSONObject jsonObject){
        JSONArray jsonArray = null;
        try {
            if (jsonObject != null && jsonObject.getString("errCode") != null &&
                    jsonObject.getString("errCode").equals(CommonUtils.DB_SERVICES_NORMAL_CODE)) {
                jsonArray = jsonObject.getJSONArray("resMsg");
            }
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return jsonArray;
    }

    private static JSONObject JsonObjectAnalysis(JSONObject jsonObject){
        JSONObject resMsgJson = null;
        JSONArray resMsgJsonArray = commonAnalysis(jsonObject);
        try {
            if(resMsgJsonArray != null && resMsgJsonArray.size() > 0) {
                resMsgJson = resMsgJsonArray.getJSONObject(0);
            }
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return resMsgJson;
    }
}
