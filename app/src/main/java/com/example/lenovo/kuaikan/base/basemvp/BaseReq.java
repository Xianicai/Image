package com.example.lenovo.kuaikan.base.basemvp;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/10.
 */

public class BaseReq extends ReqCommon<BaseBean> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        BaseBean bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),BaseBean.class);
        setT(bean);
    }
}
