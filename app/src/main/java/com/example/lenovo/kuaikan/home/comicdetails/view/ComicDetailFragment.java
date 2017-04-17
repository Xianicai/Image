package com.example.lenovo.kuaikan.home.comicdetails.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.base.ServerData;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicCommentBean;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ReqComicComment;
import com.example.lenovo.kuaikan.home.comicdetails.view.adapter.ComicDetailAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicDetailFragment extends BaseFragment {
    @BindView(R.id.comic_detial_recyclerview)
    RecyclerView mComicDetialRecyclerview;
    private ComicCommentBean mComicCommentBean;
    private ComicDetailAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comic_detail;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mComicDetialRecyclerview.setLayoutManager(layoutManager);
        getData();
        List<ComicCommentBean.DataBean.ReviewsBean> reviews = mComicCommentBean.getData().getReviews();
        mAdapter = new ComicDetailAdapter(getActivity(),reviews);
        mComicDetialRecyclerview.setAdapter(mAdapter);
    }

    private void getData() {
        ReqComicComment req = new ReqComicComment();
        req.getNetData(ServerData.COMIC_DETAIL_COMMENT);
        mComicCommentBean = req.getT();
    }

    public void setData(ComicDetailBean.DataBean dataBean) {
        mAdapter.setTopData(dataBean);
        mAdapter.notifyDataSetChanged();
    }
}
