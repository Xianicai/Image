package com.example.lenovo.kuaikan.community.comment.model.data;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class ReqComment extends ReqCommon<CommentBean> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        CommentBean bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),CommentBean.class);
        setT(bean);
    }
}
