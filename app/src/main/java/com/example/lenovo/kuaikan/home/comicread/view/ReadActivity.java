package com.example.lenovo.kuaikan.home.comicread.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.home.comicread.view.adapter.CommentAdapter;
import com.example.lenovo.kuaikan.home.comicread.view.adapter.ReadAdapter;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.home.comicread.presenter.ReadPresenter;
import com.example.lenovo.kuaikan.widget.ReadActionBar;
import com.example.lenovo.kuaikan.widget.XRecyclerview;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadActivity extends BaseActivity implements IReadView {

    @BindView(R.id.readActionBar)
    ReadActionBar mReadActionBar;
    @BindView(R.id.read_recyclerview)
    XRecyclerview mReadRecyclerview;
    @BindView(R.id.comment_recyclerview)
    XRecyclerview mCommentRecyclerview;
    @BindView(R.id.tv_like)
    TextView mTvLike;
    @BindView(R.id.tv_comment)
    TextView mTvComment;
    @BindView(R.id.tv_subscribe)
    TextView mTvSubscribe;
    @BindView(R.id.tv_share)
    TextView mTvShare;
    @BindView(R.id.image_author_head)
    GlideImageView mImageAuthorHead;
    @BindView(R.id.tv_author_name)
    TextView mTvAuthorName;
    @BindView(R.id.image_share)
    ImageView mImageShare;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.layout_comment)
    ConstraintLayout mLayoutComment;
    private ReadPresenter mReadPresenter;
    private List<String> mImages;
    private ReadAdapter mReadAdapter;
    private String mComicsId;
    private List<BeanRead.DataBean.ImageInfosBean> mImageInfos;
    private List<BeanComments.DataBean.CommentsBean> mComments;
    private CommentAdapter mCommentAdapter;
    private LinearLayoutManager mCommentlayoutManager;


    @Override
    public int getlayoutId() {
        return R.layout.activity_read;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mComicsId = getIntent().getStringExtra("comicsId");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //漫画的Recyclerview
        mImages = new ArrayList<>();
        mImageInfos = new ArrayList<>();
        mReadAdapter = new ReadAdapter(mImages, this, mImageInfos);
        mReadRecyclerview.setAdapter(mReadAdapter);
        mReadPresenter = new ReadPresenter();
        mReadPresenter.attachView(this);
        mReadPresenter.getSeverData(mComicsId);
        mReadRecyclerview.setLayoutManager(linearLayoutManager);


        //评论的Recyclerview
        mCommentlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mCommentRecyclerview.setLayoutManager(mCommentlayoutManager);
        mComments = new ArrayList<>();
        mCommentAdapter = new CommentAdapter(mComments, this);
        mCommentRecyclerview.setAdapter(mCommentAdapter);

        mReadActionBar.setOnReadActionBarListener(new ReadActionBar.OnReadActionBarListener() {
            @Override
            public void setLeftClickListener() {
                onBackPressed();
            }

            @Override
            public void setRightClickListener() {

            }
        });
        //漫画列表的滑动监听
        mReadRecyclerview.getReclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int mScrollThreshold = 4;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isSignificantDelta = Math.abs(dy) > mScrollThreshold;
                if (isSignificantDelta) {
                    if (dy > 0) {
                        mLayoutComment.setVisibility(View.VISIBLE);
                    } else {
                        mLayoutComment.setVisibility(View.GONE);
                    }
                }
            }

        });
      //评论列表的滑动监听
        RecyclerView reclerView = mCommentRecyclerview.getReclerView();
        reclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                layoutParams.height = (int) (mCommentAdapter.getItemAllHight()/2);
                recyclerView.setLayoutParams(layoutParams);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                mLayoutComment.setVisibility(View.VISIBLE);
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
    public void getServerDataSuccess(BeanRead data) {
        if (data != null) {
            mImageAuthorHead.setRounImage(data.getData().getTopic().getUser().getAvatar_url());
            mTvAuthorName.setText(data.getData().getTopic().getUser().getNickname());
            mTvCommentNum.setText(data.getData().getComments_count() + "");
            int mhight = 0;
            mReadActionBar.setActionBarTitle(data.getData().getTitle());
            mImageInfos.addAll(data.getData().getImage_infos());
            mImages.addAll(data.getData().getImages());
            for (int i = 0; i < data.getData().getImage_infos().size(); i++) {
                mhight += data.getData().getImage_infos().get(i).getHeight();
            }
            ViewGroup.LayoutParams layoutParams = mReadRecyclerview.getLayoutParams();
            layoutParams.height = (int) ((mhight + mReadActionBar.getLayoutParams().height) / 1.2);
            mReadRecyclerview.setLayoutParams(layoutParams);
            mReadAdapter.notifyDataSetChanged();

        }

    }

    @Override
    public void getCommentDataSuccss(BeanComments beanComments) {
        if (beanComments != null) {
            mComments.addAll(beanComments.getData().getComments());
            mCommentAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getServerDataFail() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
