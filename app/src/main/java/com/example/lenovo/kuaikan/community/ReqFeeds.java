package com.example.lenovo.kuaikan.community;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.home.hot.bean.BeanHomeHot;
import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/1.
 */

public class ReqFeeds extends ReqCommon<BeanFeeds> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BeanFeeds bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BeanFeeds.class);
        setT(bean);
    }
}
