package com.example.lenovo.kuaikan.discover.classify;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/2.
 */

public class ReqContent extends ReqCommon<BeanContent> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BeanContent bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BeanContent.class);
        setT(bean);
    }
}
