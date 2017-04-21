package com.example.lenovo.kuaikan.community;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.utils.ToastUtil;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;
import com.example.lenovo.kuaikan.widget.XRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/3/31.
 */

public class TopicsFragment extends BaseFragment {
    @BindView(R.id.topics_xRecyclerview)
    XRecyclerview mTopicsXRecyclerview;
    private List<String> mImageModels;
    private int mPageSize;
    private int mPageNumber = 1;
    private List<BeanFeeds.DataBean.FeedsBean> mFeedsBeen;
    private TopicsAdapter mTopicsAdapter;
    private String mCatalogType;

    public static TopicsFragment newInstance(String catalogType) {
        TopicsFragment fragment = new TopicsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("catalogType", catalogType);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.topics_fragment;
    }

    @Override
    protected void initView(View view) {
        mCatalogType = getArguments().getString("catalogType");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mTopicsXRecyclerview.setLayoutManager(linearLayoutManager);
        mTopicsXRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mTopicsXRecyclerview.setOnRefreshLoadMore(new XRecyclerview.OnRefreshLoadMore() {
            @Override
            public void onRefresh() {
                //每次刷新总是请求第一页的数据
                mPageNumber = 1;
                mFeedsBeen.clear();
                getServerData(true, false);
            }
            @Override
            public void onLoadMore() {
                if (mPageSize >17) {
                    ToastUtil.showMessage("正在拼命加载n(*≧▽≦*)n");
                    getServerData(false, true);
                }
            }
        });
        mFeedsBeen = new ArrayList<>();
        mTopicsAdapter = new TopicsAdapter(getActivity(),mFeedsBeen);
        mTopicsXRecyclerview.setAdapter(mTopicsAdapter);
        getServerData(false,false);
    }

    private void getServerData(final Boolean refresh, final Boolean loadMore) {
        mTopicsXRecyclerview.showLoading(true);
        final ReqFeeds req = new ReqFeeds();
        String url = Urls.parse(Urls.COMMUNITY_SQUARE_FEEDS, mPageNumber,mCatalogType);
        NetAsynTask.connectByGet(url, null, req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    //初始化一个bean用保存本次请求下来的数据
                    List<BeanFeeds.DataBean.FeedsBean>  feeds = new ArrayList<>();
                    BeanFeeds beanFeeds = req.getT();
                    feeds = beanFeeds.getData().getFeeds();
                    //是否有下一页
                    mPageSize = feeds.size();
                    if (mPageSize > 17) {
                        mPageNumber++;
                    }
                    // 将每次网络请求的数据添加到总的List
                    mFeedsBeen.addAll(feeds);
                    //清空为下次请求做准备
                    feeds.clear();
                    //实例化一个MainAdapter对象
                    mTopicsAdapter.notifyDataSetChanged();
                    if (refresh) {
                        mTopicsXRecyclerview.refreshFinish();
                    }
                    if (loadMore) {
                        mTopicsXRecyclerview.loadMoreFinish();
                    }
                }
            }

            @Override
            public void onGetFinished() {
                mTopicsXRecyclerview.showLoading(false);

            }

            @Override
            public void onGetFaild() {

            }

            @Override
            public void onGetError() {

            }
        });
    }

}
