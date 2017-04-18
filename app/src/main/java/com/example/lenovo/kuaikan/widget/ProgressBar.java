package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

/**
 * Created by Zhanglibin on 2017/4/18.
 */

public class ProgressBar {
    public void showProgressBar(Context context){
        CircleProgressBar mProgressBar = new CircleProgressBar(context);
        mProgressBar.setLayoutParams(new ViewGroup.LayoutParams(80,80));
    }
}
