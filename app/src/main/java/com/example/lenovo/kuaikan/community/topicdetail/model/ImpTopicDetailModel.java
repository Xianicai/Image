package com.example.lenovo.kuaikan.community.topicdetail.model;

import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/17.
 */

public interface ImpTopicDetailModel {
    void getCommentData(String feedId,Callback<CommentBean> callback);
}
