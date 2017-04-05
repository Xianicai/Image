package com.example.lenovo.kuaikan.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Zhanglibin on 2017/3/28.
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder mUnbinder;

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



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        initView(view);
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
