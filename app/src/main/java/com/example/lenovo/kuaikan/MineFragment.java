package com.example.lenovo.kuaikan;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.lenovo.kuaikan.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }


    @Override
    protected void initView(View view) {

    }

}
