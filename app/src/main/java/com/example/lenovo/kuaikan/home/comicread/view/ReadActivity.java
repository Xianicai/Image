package com.example.lenovo.kuaikan.home.comicread.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.community.comment.view.CommentActivity;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.home.comicread.presenter.ReadPresenterImpl;
import com.example.lenovo.kuaikan.home.comicread.view.adapter.ReadAdapter;
import com.example.lenovo.kuaikan.widget.ReadActionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ReadActivity extends BaseActivity implements IReadView {


    @BindView(R.id.readActionBar)
    ReadActionBar mReadActionBar;
    @BindView(R.id.read_recyclerview)
    RecyclerView mReadRecyclerview;
    @BindView(R.id.image_comment)
    ImageView mImageComment;
    @BindView(R.id.image_share)
    ImageView mImageShare;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.layout_comment)
    ConstraintLayout mLayoutComment;
    private ReadPresenterImpl mReadPresenter;
    private List<String> mImages;
    private ReadAdapter mReadAdapter;
    private String mComicsId;
    private List<BeanRead.DataBean.ImageInfosBean> mImageInfos;
    private String comicId;

    @Override
    public int getlayoutId() {
        return R.layout.activity_read;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mComicsId = getIntent().getStringExtra("comicsId");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //漫画的Recyclerview
        mImages = new ArrayList<>();
        mImageInfos = new ArrayList<>();
        mReadAdapter = new ReadAdapter(mImages, this, mImageInfos, mComicsId);
        mReadRecyclerview.setAdapter(mReadAdapter);
        mReadPresenter = new ReadPresenterImpl();
        mReadPresenter.bindView(this);
        mReadPresenter.getSeverData(mComicsId);
        mReadRecyclerview.setLayoutManager(linearLayoutManager);
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
            comicId = data.getData().getPrevious_comic_id()+"";
            mTvCommentNum.setText(data.getData().getComments_count() + "");
            mReadActionBar.setActionBarTitle(data.getData().getTitle());
            mImageInfos.addAll(data.getData().getImage_infos());
            mImages.addAll(data.getData().getImages());
            mReadAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getServerDataFail() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick({R.id.image_comment, R.id.image_share, R.id.layout_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_comment:
                CommentActivity.toComment(this,comicId,1);
                break;
            case R.id.image_share:
                break;
            case R.id.layout_comment:
                break;
        }
    }
}
