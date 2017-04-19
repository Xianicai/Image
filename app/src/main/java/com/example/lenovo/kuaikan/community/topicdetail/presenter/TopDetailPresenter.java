package com.example.lenovo.kuaikan.community.topicdetail.presenter;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenterImpl;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.topicdetail.model.TopicDetailModel;
import com.example.lenovo.kuaikan.community.topicdetail.view.ImpTopDetailView;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/17.
 */

public class TopDetailPresenter extends BasePresenterImpl<ImpTopDetailView> {

    private final TopicDetailModel mModel;

    public TopDetailPresenter() {
        mModel = new TopicDetailModel();
    }
    public void getTopDetialData(String feedId){
        mModel.getCommentData(feedId,new Callback<CommentBean>() {
            @Override
            public void execute(CommentBean obj) {
                if (obj != null) {
                    getView().getCommentDataSuccess(obj);
                }
            }
        });
    }
}
