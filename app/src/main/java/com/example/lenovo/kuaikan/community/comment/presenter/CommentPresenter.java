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
    public void getServerData(){
        mModel.getServerData("",new Callback<CommentBean>() {
            @Override
            public void execute(CommentBean obj) {
                if (obj != null) {
                    getMvpView().getServerDataSuccess(obj);
                }
            }
        });
    }

}
