package com.example.lenovo.kuaikan.home.comicread.model.data;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/11.
 */

public class ReqComments extends ReqCommon<BeanComments> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BeanComments bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BeanComments.class);
        setT(bean);
    }
}
