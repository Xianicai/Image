package com.example.lenovo.kuaikan.home.hot.reqhot;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.home.hot.bean.BeanHomeHot;
import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/3/31.
 */

public class ReqHot extends ReqCommon<BeanHomeHot> {


    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BeanHomeHot bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BeanHomeHot.class);
        setT(bean);
    }
}
