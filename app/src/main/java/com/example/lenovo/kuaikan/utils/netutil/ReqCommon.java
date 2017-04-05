package com.example.lenovo.kuaikan.utils.netutil;

import android.support.annotation.NonNull;

import org.json.JSONObject;

/**
 * ZY:
 * Created by zhanglibin on 2016/9/5.
 */
public abstract class ReqCommon<T> {
    public int code;
    public String message;
    public T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void getNetData(String paramString){
        try {
            JSONObject jsonObject = new JSONObject(paramString);
            code = jsonObject.optInt("code");
            if (code != 200) {
                message = jsonObject.optString("message");
            }
            parseResult(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void parseResult(@NonNull JSONObject jsonObject) throws Exception;

}
