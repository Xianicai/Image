package com.example.lenovo.kuaikan.community.topicdetail.view;

import com.example.lenovo.kuaikan.base.basemvp.BaseView;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;

/**
 * Created by Zhanglibin on 2017/4/17.
 */

public interface ImpTopDetailView extends BaseView {
    void getCommentDataSuccess(CommentBean bean);
}
