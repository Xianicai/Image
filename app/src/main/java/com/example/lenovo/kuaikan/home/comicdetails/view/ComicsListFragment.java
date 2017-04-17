package com.example.lenovo.kuaikan.home.comicdetails.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicdetails.view.adapter.ComicListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicsListFragment extends BaseFragment {
    @BindView(R.id.comic_list_recyclerview)
    RecyclerView mComicListRecyclerview;
    private ComicListAdapter mAdapter;
    private List<ComicDetailBean.DataBean.ComicsBean> mComics;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comic_list;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mComicListRecyclerview.setLayoutManager(layoutManager);
        mComics = new ArrayList<>();
        mAdapter = new ComicListAdapter(getActivity(),mComics);
        mComicListRecyclerview.setAdapter(mAdapter);

    }

    public void setData(ComicDetailBean.DataBean dataBean) {
        mComics.addAll(dataBean.getComics());
        mAdapter.setTopData(dataBean.getUpdate_status()+dataBean.getUpdate_day());
        mAdapter.notifyDataSetChanged();
    }

}
