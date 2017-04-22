package com.example.lenovo.kuaikan.community.comment.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.presenter.CommentPresenter;
import com.example.lenovo.kuaikan.community.comment.view.adpater.CommentHotAdapter;
import com.example.lenovo.kuaikan.utils.StringUtil;
import com.example.lenovo.kuaikan.utils.ToastUtil;
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
    private List<CommentBean.DataBean.CommentsBean> mComments;
    private CommentHotAdapter mCommentAdapter;
    private int firstId;
    private boolean mRefresh;
    private boolean mLoadMore;
    private int mPageSize;
    /**
     * 评论的TYPE  1：漫画评论，2;动态评论
     */
    private int mCommentType;

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
        mComments = new ArrayList<>();
        mCommentAdapter = new CommentHotAdapter(mComments, getActivity());
        mHotCommentRecyclerview.setAdapter(mCommentAdapter);
        mHotCommentRecyclerview.setOnRefreshLoadMore(new XRecyclerview.OnRefreshLoadMore() {
            @Override
            public void onRefresh() {
                mPageSize = 0;
                mRefresh = true;
                mLoadMore = false;
                firstId = 0;
                if (mCommentType == 1) {
                    mPresenter.getComicsComment(type, feedId, firstId);
                } else {
                    mPresenter.getServerData(type, feedId, firstId);
                }
            }

            @Override
            public void onLoadMore() {
                if (mPageSize >= 17) {
                    ToastUtil.showMessage("正在拼命加载n(*≧▽≦*)n");
                    mRefresh = false;
                    mLoadMore = true;
                    if (mCommentType == 1) {
                        //此处俩个页面是俩中分页方法 （最新评论是每次拿上一次请求的最后一条数据的id）（最热评论是每次+20）
                        if (StringUtil.equals("", type)) {
                            firstId = mComments.get(mComments.size() - 1).getId();
                        } else {
                            firstId += 20;
                        }
                        mPresenter.getComicsComment(type, feedId, firstId);
                    } else {
                        //此处俩个页面是俩中分页方法 （最新评论是每次拿上一次请求的最后一条数据的id）（最热评论是每次+20）
                        if (StringUtil.equals("time", type)) {
                            firstId = mComments.get(mComments.size() - 1).getId();
                        } else {
                            firstId += 20;
                        }
                        mPresenter.getServerData(type, feedId, firstId);
                    }

                }
            }
        });
        mPresenter = new CommentPresenter();
        mPresenter.bindView(this);
        firstId = 0;
        if (mCommentType == 1) {
            mPresenter.getComicsComment(type, feedId, firstId);
        } else {
            mPresenter.getServerData(type, feedId, firstId);
        }
    }


    @Override
    public void showMsg(String str) {

    }

    @Override
    public void showLoadingDialog() {
        mHotCommentRecyclerview.showLoading(true);
    }

    @Override
    public void cancelLoadingDialog() {
        mHotCommentRecyclerview.showLoading(false);
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
            mPageSize = data.getData().getComments().size();
            mComments.addAll(data.getData().getComments());
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
            mPageSize = data.getData().getComments().size();
            mComments.addAll(data.getData().getComments());
            mCommentAdapter.notifyDataSetChanged();
        }
    }
}
