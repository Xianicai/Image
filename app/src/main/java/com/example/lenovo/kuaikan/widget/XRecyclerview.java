package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.ToastUtil;

/**
 * Created by Zhanglibin on 2017/3/31.
 */

public class XRecyclerview extends LinearLayout {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    public void setOnRefreshLoadMore(OnRefreshLoadMore onRefreshLoadMore) {
        mOnRefreshLoadMore = onRefreshLoadMore;
    }

    OnRefreshLoadMore mOnRefreshLoadMore;
    RecyclerView.Adapter mAdapter;
    LinearLayoutManager mManager;

    public XRecyclerview(Context context) {
        this(context, null);
    }

    public XRecyclerview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerview(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.xrecyclerview, this);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context, R.color.yellow));
        if (mManager != null) {
            setRefreshLoadMore();
        }
    }

    //下拉刷新 上拉加载
    private void setRefreshLoadMore() {
        //下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (mOnRefreshLoadMore != null) {
                    mOnRefreshLoadMore.onRefresh();
                }
            }
        });

        //上拉加载
        mRecyclerView.addOnScrollListener(new EndLessOnScrollListener(mManager) {
            @Override
            public void onLoadMore(int currentPage) {
                if (mOnRefreshLoadMore != null) {
                    mOnRefreshLoadMore.onLoadMore();
                }
            }
        });
    }

    public interface OnRefreshLoadMore {
        void onRefresh();

        void onLoadMore();

    }

    //设置布局管理器
    public void setLayoutManager(LinearLayoutManager mManager) {
        if (mManager != null) {
            this.mManager = mManager;
            mRecyclerView.setLayoutManager(mManager);
            setRefreshLoadMore();
        }

    }

    //设置动画
    public void setItemAnimator(RecyclerView.ItemAnimator animator) {
        mRecyclerView.setItemAnimator(animator);
    }

    //设置Adapter
    public void setAdapter(RecyclerView.Adapter adapter) {
        mAdapter = adapter;
        mRecyclerView.setAdapter(adapter);
    }

    //下拉刷新成功
    public void refreshFinish() {
        mAdapter.notifyDataSetChanged();
        //显示或者隐藏刷新进度条
        mSwipeRefreshLayout.setRefreshing(false);
        ToastUtil.showMessage("刷新成功n(*≧▽≦*)n");
    }

    //上拉加载成功
    public void loadMoreFinish() {
        mAdapter.notifyDataSetChanged();
    }
    //是否显示加载框
    public void showLoading(boolean show){
        if (show) {
            mSwipeRefreshLayout.setRefreshing(true);
        }else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
