package com.example.lenovo.kuaikan.community.topicdetail.model;

import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.model.data.ReqComment;
import com.example.lenovo.kuaikan.utils.Callback;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;

/**
 * Created by Zhanglibin on 2017/4/17.
 */

public class TopicDetailModel implements ImpTopicDetailModel {

    @Override
    public void getCommentData(String feedId,final Callback<CommentBean> callback) {
        final ReqComment req = new ReqComment();
        String url = Urls.parse(Urls.TOPIC_DETAIL_COMMENT,feedId);
        NetAsynTask.connectByGet(url,null,req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    CommentBean commentBean = req.getT();
                    callback.execute(commentBean);
                }
            }

            @Override
            public void onGetFinished() {

            }

            @Override
            public void onGetFaild() {

            }

            @Override
            public void onGetError() {

            }
        });
    }
}
