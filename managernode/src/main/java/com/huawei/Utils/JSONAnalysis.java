package com.huawei.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONAnalysis {
    public static JSONObject analysisDbJson(JSONObject result){
        JSONObject jsonObject =new JSONObject();
        if(result !=null && result.get("errCode") != null && result.get("errCode").equals(CommonUtils.DB_NORMAL_CODE)){
            jsonObject.put("errCode",CommonUtils.NORMAL_CODE);
            jsonObject.put("resMsg",result.get("resMsg"));
        }else {
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            if(result != null) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(result);
                jsonObject.put("resMsg", jsonArray);
            }else{
                jsonObject.put("resMsg", "Database service return is null!");
            }
        }
        return jsonObject;
    }
}
