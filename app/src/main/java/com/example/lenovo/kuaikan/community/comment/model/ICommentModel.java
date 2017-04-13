package com.example.lenovo.kuaikan.community.comment.model;

import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public interface ICommentModel  {
    void getServerData(String type,Callback<CommentBean> beanCallback );
}
