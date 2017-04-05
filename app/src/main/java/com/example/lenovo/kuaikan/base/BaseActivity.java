package com.example.lenovo.kuaikan.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 ZY:基础的Aty,实现简单的接口，方法
 * Created by zhanglibin.
 */
public abstract class BaseActivity extends AppCompatActivity  {
    private Unbinder mUnbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        //初始化黄油刀控件绑定框架
        mUnbinder=  ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
    public abstract int getlayoutId();
    public abstract void initViews(Bundle savedInstanceState);
}
