package com.example.lenovo.kuaikan.community.comment.view;

import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class NewCommentFragment extends BaseFragment {
    public static NewCommentFragment newInstantac(){
        NewCommentFragment fragment = new NewCommentFragment();
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_comment_new;
    }

    @Override
    protected void initView(View view) {

    }
}
