package com.example.lenovo.kuaikan.home.comicdetails.model.data;

import android.support.annotation.NonNull;

import com.example.lenovo.kuaikan.home.hot.bean.BeanHomeHot;
import com.example.lenovo.kuaikan.utils.netutil.ReqCommon;

import org.json.JSONObject;

/**
 * Created by Zhanglibin on 2017/4/15.
 */

public class ReqComicDetail extends ReqCommon<ComicDetailBean> {

    @Override
    protected void parseResult(@NonNull JSONObject jsonObject) throws Exception {
        ComicDetailBean bean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(),ComicDetailBean.class);
        setT(bean);
    }
}
