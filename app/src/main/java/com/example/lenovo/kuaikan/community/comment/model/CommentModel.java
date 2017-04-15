package com.example.lenovo.kuaikan.community.comment.model;

import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.model.data.ReqComment;
import com.example.lenovo.kuaikan.utils.Callback;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class CommentModel implements ICommentModel {

    @Override
    public void getServerData(String feedId,String type,int firstId ,final Callback<CommentBean> beanCallback) {
        final ReqComment req = new ReqComment();
        String url = Urls.parse(Urls.COMMUNITY_COMMENT, feedId,type,firstId+"");
        NetAsynTask.connectByGet(url,null,req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    CommentBean commentBean = req.getT();
                    beanCallback.execute(commentBean);
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

    @Override
    public void getComicsComment(String feedId, String type, int firstId, final Callback<CommentBean> beanCallback) {
        final ReqComment req = new ReqComment();
        String url = Urls.parse(Urls.COMIC_COMMENT, feedId,firstId,type);
        NetAsynTask.connectByGet(url,null,req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    CommentBean commentBean = req.getT();
                    beanCallback.execute(commentBean);
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
