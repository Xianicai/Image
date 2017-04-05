package com.example.lenovo.kuaikan.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Zhanglibin on 2017/4/3.
 */

public abstract class LazyFragmen extends Fragment {
    private Unbinder mUnbinder;
    protected boolean isVisible;
    private boolean mCreatView;

    public  abstract int  getLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)
    {
        int layoutId = getLayoutId();
        if (layoutId > 0) {
            View root = inflater.inflate(layoutId, container, false);
            return root;
        }
        return super.onCreateView(inflater, container, state);
    }

    protected void onVisible(){
        lazyLoad();
    }
    protected abstract void lazyLoad();
    protected void onInvisible(){}


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        initView(view);
        mCreatView = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected abstract void initView(View view);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
