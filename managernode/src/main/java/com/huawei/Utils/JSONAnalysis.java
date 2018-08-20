package com.huawei.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

public class JSONAnalysis {

    private static Logger log = Logger.getLogger(JSONAnalysis.class);

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

    public static JSONObject analysisGoodsCountJson(JSONObject result){
        JSONObject jsonObject = new JSONObject();
        if(result !=null && result.get("errCode") != null && result.get("errCode").equals(CommonUtils.DB_NORMAL_CODE)){
            JSONArray jsonArray = result.getJSONArray("resMsg");
            if(jsonArray != null && jsonArray.size() > 0){
                try {
                    int goodsCount = jsonArray.getJSONObject(0).getIntValue("goodsCount");
                    jsonObject .put("errCode",CommonUtils.NORMAL_CODE);
                    jsonObject.put("resMsg",goodsCount);
                }catch (Exception e){
                    jsonObject.put("errCode",CommonUtils.ERROR_CODE);
                    jsonObject.put("resMsg",-1);
                    log.error(e);
                    e.printStackTrace();
                }
            }else {
                jsonObject.put("errCode",CommonUtils.ERROR_CODE);
                jsonObject.put("resMsg",-1);
            }
        }else {
            jsonObject.put("errCode",CommonUtils.ERROR_CODE);
            jsonObject.put("resMsg",-1);
        }
        return jsonObject;
    }
}
