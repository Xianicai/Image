package com.example.lenovo.kuaikan.community.comment.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.base.ServerData;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentTopicBean;
import com.example.lenovo.kuaikan.community.comment.model.data.ReqComment;
import com.example.lenovo.kuaikan.community.comment.model.data.ReqCommentTopic;
import com.example.lenovo.kuaikan.community.comment.presenter.CommentPresenter;
import com.example.lenovo.kuaikan.community.comment.view.adpater.CommentHotAdapter;
import com.example.lenovo.kuaikan.community.comment.view.adpater.CommentTopicAdapter;
import com.example.lenovo.kuaikan.utils.StringUtil;
import com.example.lenovo.kuaikan.widget.XRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class HotCommentFragment extends BaseFragment implements ICommentView {

    @BindView(R.id.hot_comment)
    XRecyclerview mHotCommentRecyclerview;
    private CommentPresenter mPresenter;
    private List<CommentBean.DataBean.CommentFloorsBean> mComments;
    List<CommentTopicBean.DataBean.CommentFloorsBean> mTopicComments;
    private CommentHotAdapter mCommentAdapter;
    private String firstId;
    private boolean mRefresh;
    private boolean mLoadMore;
    private int mPageSize;
    private int pageNumber;
    /**
     * 评论的TYPE  1：漫画评论，2;动态评论 return HotCommentFragment.newInstantac("", feedId, commentType);
     */
    private int mCommentType;
    private CommentTopicAdapter mCommentTopicAdapter;

    public static HotCommentFragment newInstantac(String type, String feedId, int commentType) {
        HotCommentFragment fragment = new HotCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        bundle.putString("feedId", feedId);
        bundle.putInt("commentType", commentType);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comment_hot;
    }

    @Override
    protected void initView(View view) {
        final String type = getArguments().getString("type");
        final String feedId = getArguments().getString("feedId");
        mCommentType = getArguments().getInt("commentType");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mHotCommentRecyclerview.setLayoutManager(layoutManager);
        if (mCommentType == 1) {
            mComments = new ArrayList<>();
            mCommentAdapter = new CommentHotAdapter(mComments, getActivity());
            mHotCommentRecyclerview.setAdapter(mCommentAdapter);
        } else {
            mTopicComments = new ArrayList<>();
            mCommentTopicAdapter = new CommentTopicAdapter(mTopicComments, getActivity());
            mHotCommentRecyclerview.setAdapter(mCommentTopicAdapter);
        }


//        mHotCommentRecyclerview.setOnRefreshLoadMore(new XRecyclerview.OnRefreshLoadMore() {
//            @Override
//            public void onRefresh() {
//                mPageSize = 0;
//                mRefresh = true;
//                mLoadMore = false;
//                pageNumber = 0;
//                firstId = pageNumber + "";
//                if (mCommentType == 1) {
//                    mPresenter.getComicsComment(type, feedId, firstId);
//                } else {
//                    mPresenter.getServerData(type, feedId, firstId);
//                }
//            }
//
//            @Override
//            public void onLoadMore() {
//                if (mPageSize >= 17) {
//                    ToastUtil.showMessage("正在拼命加载n(*≧▽≦*)n");
//                    mRefresh = false;
//                    mLoadMore = true;
//                    if (mCommentType == 1) {
//                        //此处俩个页面是俩中分页方法 （最新评论是每次拿上一次请求的最后一条数据的id）（最热评论是每次+20）
//                        if (StringUtil.equals("", type)) {
////                            firstId = mComments.get(mComments.size() - 1).getId();
//                        } else {
//                            pageNumber += 20;
//                            firstId = pageNumber + "";
//                        }
//                        mPresenter.getComicsComment(type, feedId, firstId + "");
//                    } else {
//                        //此处俩个页面是俩中分页方法 （最新评论是每次拿上一次请求的最后一条数据的id）（最热评论是每次+20）
//                        if (StringUtil.equals("time", type)) {
////                            firstId = mComments.get(mComments.size() - 1).getId();
//                        } else {
//                            pageNumber += 20;
//                            firstId = pageNumber + "";
//
//                        }
//                        mPresenter.getServerData(type, feedId, firstId + "");
//                    }
//
//                }
//            }
//        });
        mPresenter = new CommentPresenter();
        mPresenter.bindView(this);
        firstId = pageNumber + "";
        if (mCommentType == 1) {
//            mPresenter.getComicsComment(type, feedId, firstId+"");
// FIXME: 2017/8/14 没有数据修改
            if (StringUtil.equals("1", type)) {
                getComicsCommentData(ServerData.COMMIC_COMMENT_NEW);

            } else if (StringUtil.equals("2", type)) {
                getComicsCommentData(ServerData.COMMIC_COMMENT_HOT);
            }

        } else {
//            mPresenter.getServerData(type, feedId, firstId+"");
// FIXME: 2017/8/14 没有数据修改
            if (StringUtil.equals("3", type)) {
                getComicsCommentTopicData(ServerData.TOPIC_COMMENT_NEW);

            } else if (StringUtil.equals("4", type)) {
                getComicsCommentTopicData(ServerData.TOPIC_COMMENT_HOT);
            }
        }
    }

    private void getComicsCommentData(String data) {
        ReqComment req = new ReqComment();
        req.getNetData(data);
        List<CommentBean.DataBean.CommentFloorsBean> comments = req.getT().getData().getComment_floors();
        mComments.clear();
        mComments.addAll(comments);
        mCommentAdapter.notifyDataSetChanged();
    }

    private void getComicsCommentTopicData(String data) {
        ReqCommentTopic req = new ReqCommentTopic();
        req.getNetData(data);
//        List<CommentTopicBean.DataBean.CommentFloorsBean> comments = req.getT().getData().getComment_floors();
        CommentTopicBean t = req.getT();
        mTopicComments.clear();
        mTopicComments.addAll(t.getData().getComment_floors());
        mCommentTopicAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMsg(String str) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }


    @Override
    public void getServerDataSuccess(CommentBean data) {
        if (data != null) {
            if (mRefresh) {
                mComments.clear();
                mHotCommentRecyclerview.refreshFinish();
            }
            if (mLoadMore) {
                mHotCommentRecyclerview.loadMoreFinish();
            }
//            mPageSize = data.getData().getComments().size();
//            mComments.addAll(data.getData().getComments());
            mCommentAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getComicsCommentDataSucess(CommentBean data) {
        if (data != null) {
            if (mRefresh) {
                mComments.clear();
                mHotCommentRecyclerview.refreshFinish();
            }
            if (mLoadMore) {
                mHotCommentRecyclerview.loadMoreFinish();
            }
//            mPageSize = data.getData().getComments().size();
//            mComments.addAll(data.getData().getComments());
            mCommentAdapter.notifyDataSetChanged();
        }
    }
}
