package com.example.lenovo.kuaikan.community.comment.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.presenter.CommentPresenter;
import com.example.lenovo.kuaikan.community.comment.view.adpater.CommentHotAdapter;
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

    public static HotCommentFragment newInstantac() {
        HotCommentFragment fragment = new HotCommentFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comment_hot;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mHotCommentRecyclerview.setLayoutManager(layoutManager);
        mComments = new ArrayList<>();
        mCommentAdapter = new CommentHotAdapter(mComments,getActivity());
        mHotCommentRecyclerview.setAdapter(mCommentAdapter);
        mPresenter = new CommentPresenter();
        mPresenter.attachView(this);
        mPresenter.getServerData();
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
            mComments.addAll(data.getData().getComments());
            mCommentAdapter.notifyDataSetChanged();
        }
    }
}
