package com.example.lenovo.kuaikan.community.comment.model;

import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public interface ICommentModel  {
//    获取社区评论
    void getServerData( String feedId,String type,int firstId ,Callback<CommentBean> beanCallback );
//    获取漫画页面评论
    void getComicsComment(String feedId,String type,int firstId ,Callback<CommentBean> beanCallback);
}
