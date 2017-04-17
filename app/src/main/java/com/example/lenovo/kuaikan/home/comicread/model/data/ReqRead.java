package com.example.lenovo.kuaikan.home.comicread.model.data;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReqRead extends ReqCommon<BeanRead> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BeanRead bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BeanRead.class);
        setT(bean);
    }
}
