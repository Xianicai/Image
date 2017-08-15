package com.example.lenovo.kuaikan.community.comment.model.data;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class ReqCommentTopic extends ReqCommon<CommentTopicBean> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        CommentTopicBean bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),CommentTopicBean.class);
        setT(bean);
    }
}
