package com.example.lenovo.kuaikan.community.comment.view;

import com.example.lenovo.kuaikan.base.basemvp.BaseView;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public interface ICommentView extends BaseView {
    void getServerDataSuccess(CommentBean data);
    void getComicsCommentDataSucess(CommentBean data);
}
