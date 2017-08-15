package com.example.lenovo.kuaikan.community.topicdetail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.community.BeanFeeds;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.topicdetail.presenter.TopDetailPresenter;
import com.example.lenovo.kuaikan.community.topicdetail.view.adapter.TopicDetailAdapter;
import com.example.lenovo.kuaikan.widget.ReadActionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TopicDetailActivity extends BaseActivity implements ImpTopDetailView {


    @BindView(R.id.action_bar)
    ReadActionBar mActionBar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.layout_comment)
    ConstraintLayout mLayoutComment;
    private List<CommentBean.DataBean.CommentFloorsBean> mComments;
    private TopicDetailAdapter mAdapter;
    private BeanFeeds.DataBean.FeedsBean mFeedsBean;

    @Override
    public int getlayoutId() {
        return R.layout.activity_topic_detail;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mFeedsBean = getIntent().getParcelableExtra("mFeedsBean");
        String feedId = getIntent().getStringExtra("feedId");
        mTvCommentNum.setText(mFeedsBean.getComments_count()+"");
        TopDetailPresenter presenter = new TopDetailPresenter();
        presenter.bindView(this);
        presenter.getTopDetialData(feedId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(layoutManager);
        mComments = new ArrayList<>();
        mAdapter = new TopicDetailAdapter(this, mComments, mFeedsBean);
        mRecyclerview.setAdapter(mAdapter);
        mActionBar.setOnReadActionBarListener(new ReadActionBar.OnReadActionBarListener() {
            @Override
            public void setLeftClickListener() {
                onBackPressed();
            }

            @Override
            public void setRightClickListener() {

            }
        });
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
    public void getCommentDataSuccess(CommentBean bean) {
        if (bean != null) {
            mComments.addAll(bean.getData().getComment_floors());
            mAdapter.notifyDataSetChanged();
        }
    }

    public static void toTopDetail(Context context, BeanFeeds.DataBean.FeedsBean mFeedsBean, String feedId) {
        Intent intent = new Intent(context, TopicDetailActivity.class);
        intent.putExtra("mFeedsBean", mFeedsBean);
        intent.putExtra("feedId", feedId);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
