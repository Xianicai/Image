package com.example.lenovo.kuaikan.discover;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.community.BeanFeeds;
import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/5.
 */

public class ReqRecomm extends ReqCommon<BeanRecomm> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BeanRecomm bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BeanRecomm.class);
        setT(bean);
    }
}
