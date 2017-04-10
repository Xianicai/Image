package com.example.lenovo.kuaikan.business.read.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.business.read.adapter.ReadAdapter;
import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.business.read.mvp.presenter.ReadPresenter;
import com.example.lenovo.kuaikan.widget.ReadActionBar;
import com.example.lenovo.kuaikan.widget.XRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ReadActivity extends BaseActivity implements IReadView {

    @BindView(R.id.readActionBar)
    ReadActionBar mReadActionBar;
    @BindView(R.id.read_recyclerview)
    XRecyclerview mReadRecyclerview;
    private ReadPresenter mReadPresenter;
    private List<String> mImages;
    private ReadAdapter mReadAdapter;
    private String mComicsId;


    @Override
    public int getlayoutId() {
        return R.layout.activity_read;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mComicsId = getIntent().getStringExtra("comicsId");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mReadRecyclerview.setLayoutManager(linearLayoutManager);
        mImages = new ArrayList<>();
        mReadAdapter = new ReadAdapter(mImages, this);
        mReadRecyclerview.setAdapter(mReadAdapter);
        mReadPresenter = new ReadPresenter();
        mReadPresenter.attachView(this);
        mReadPresenter.getSeverData(mComicsId);
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
            mReadActionBar.setActionBarTitle(data.getData().getTitle());
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
}
