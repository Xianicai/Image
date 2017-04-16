package com.example.lenovo.kuaikan.community.comment.presenter;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenter;
import com.example.lenovo.kuaikan.community.comment.model.CommentModel;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.view.ICommentView;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class CommentPresenter extends BasePresenter<ICommentView> {
    CommentModel mModel;

    public CommentPresenter() {
        mModel = new CommentModel();
    }

    //    获取状态的评论
    public void getServerData(String type, String feedId, int limit) {
        mModel.getServerData(feedId, type, limit, new Callback<CommentBean>() {
            @Override
            public void execute(CommentBean obj) {
                if (obj != null) {
                    getMvpView().getServerDataSuccess(obj);
                }
            }
        });

    }

    //    获取漫画的评论
    public void getComicsComment(String type, String feedId, int limit) {
        mModel.getComicsComment(feedId, type, limit, new Callback<CommentBean>() {
            @Override
            public void execute(CommentBean obj) {
                if (obj != null) {
                    getMvpView().getServerDataSuccess(obj);
                }
            }
        });

    }
}