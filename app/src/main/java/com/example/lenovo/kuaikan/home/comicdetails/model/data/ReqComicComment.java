package com.example.lenovo.kuaikan.home.comicdetails.model.data;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ReqComicComment extends ReqCommon<ComicCommentBean> {
    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        ComicCommentBean bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),ComicCommentBean.class);
        setT(bean);
    }
}
