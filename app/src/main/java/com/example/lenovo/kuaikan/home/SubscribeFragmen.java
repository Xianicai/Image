package com.example.lenovo.kuaikan.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.kuaikan.LoginActivity;
import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Zhanglibin on 2017/3/29.
 */

public class SubscribeFragmen extends BaseFragment {
    @BindView(R.id.imageView)
    ImageView mImageView;

    @Override
    public int getLayoutId() {
        return R.layout.subscribe_fragment;
    }

    @Override
    protected void initView(View view) {

    }


    @OnClick(R.id.imageView)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
