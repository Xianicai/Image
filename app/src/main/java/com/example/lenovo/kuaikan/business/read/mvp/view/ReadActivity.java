package com.example.lenovo.kuaikan.business.read.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.business.read.adapter.CommentAdapter;
import com.example.lenovo.kuaikan.business.read.adapter.ReadAdapter;
import com.example.lenovo.kuaikan.business.read.data.BeanComments;
import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.business.read.mvp.presenter.ReadPresenter;
import com.example.lenovo.kuaikan.widget.ReadActionBar;
import com.example.lenovo.kuaikan.widget.XRecyclerview;

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
    private ReadPresenter mReadPresenter;
    private List<String> mImages;
    private ReadAdapter mReadAdapter;
    private String mComicsId;
    private List<BeanRead.DataBean.ImageInfosBean> mImageInfos;
    private List<BeanComments.DataBean.CommentsBean> mComments;
    private CommentAdapter mCommentAdapter;


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
        mCommentRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
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
            int mhight = 0;
            mReadActionBar.setActionBarTitle(data.getData().getTitle());
            mImageInfos.addAll(data.getData().getImage_infos());
            mImages.addAll(data.getData().getImages());

            for (int i = 0; i < data.getData().getImage_infos().size(); i++) {
                mhight += data.getData().getImage_infos().get(i).getHeight();
            }

            ViewGroup.LayoutParams layoutParams = mReadRecyclerview.getLayoutParams();
            layoutParams.height = (int) ((mhight + mReadActionBar.getLayoutParams().height) / 1.31);
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
