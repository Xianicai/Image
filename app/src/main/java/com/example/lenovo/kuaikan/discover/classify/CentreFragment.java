package com.example.lenovo.kuaikan.discover.classify;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.utils.ToastUtil;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;
import com.example.lenovo.kuaikan.widget.XRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Zhanglibin on 2017/4/2.
 */

public class CentreFragment extends BaseFragment {
    @BindView(R.id.tv_recommend)
    TextView mTvRecommend;
    @BindView(R.id.tv_hot)
    TextView mTvHot;
    @BindView(R.id.tv_new)
    TextView mTvNew;
    @BindView(R.id.content_xRecyclerview)
    XRecyclerview mContentXRecyclerview;
    private FragmentTransaction mFragmentTransaction;
    private String mTag;
    private String mSort;
    private int since;
    private int mPageSize;
    private List<BeanContent.DataBean.TopicsBean> mTopicsBeen;
    private CentreAdapter mCentreAdapter;

    public static CentreFragment newInstance(String tag) {
        CentreFragment fragment = new CentreFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.centre_fragment;
    }

    @Override
    protected void initView(View view) {
        mTag = getArguments().getString("tag");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mContentXRecyclerview.setLayoutManager(linearLayoutManager);
        mContentXRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mContentXRecyclerview.setOnRefreshLoadMore(new XRecyclerview.OnRefreshLoadMore() {
            @Override
            public void onRefresh() {
                //每次刷新总是请求第一页的数据
                since = 0;
                getServerData(true, false);
            }

            @Override
            public void onLoadMore() {
                if (mPageSize == 20) {
                    ToastUtil.showMessage("正在拼命加载n(*≧▽≦*)n");
                    getServerData(false, true);
                }
            }
        });
        mTopicsBeen = new ArrayList<>();
        mSort = "1";
        mCentreAdapter = new CentreAdapter(getActivity(), mTopicsBeen,mSort);
        mContentXRecyclerview.setAdapter(mCentreAdapter);
        //初始化选中第一个tab
        setTabBackgroud(mTvRecommend);
        getServerData(false, false);

    }

    @OnClick({R.id.tv_recommend, R.id.tv_hot, R.id.tv_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_recommend:
                mSort = "1";
                getServerData(true, false);
                setTabBackgroud(mTvRecommend);
                break;
            case R.id.tv_hot:
                mCentreAdapter = new CentreAdapter(getActivity(), mTopicsBeen,"2");
                mContentXRecyclerview.setAdapter(mCentreAdapter);
                mSort = "2";
                setTabBackgroud(mTvHot);
                getServerData(true, false);
                break;
            case R.id.tv_new:
                mCentreAdapter = new CentreAdapter(getActivity(), mTopicsBeen,"3");
                mContentXRecyclerview.setAdapter(mCentreAdapter);
                mSort = "3";
                setTabBackgroud(mTvNew);
                getServerData(true, false);
                break;
        }
    }

    private void setTabBackgroud(TextView textView) {
        mTvRecommend.setTextColor(ContextCompat.getColor(getActivity(), R.color.gray));
        mTvHot.setTextColor(ContextCompat.getColor(getActivity(),R.color.gray));
        mTvNew.setTextColor(ContextCompat.getColor(getActivity(),R.color.gray));
        textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.brown));

    }

    private void getServerData(final Boolean refresh, final Boolean loadMore) {
        mContentXRecyclerview.showLoading(true);
        final ReqContent req = new ReqContent();
        String url = Urls.parse(Urls.DISCOVER_CLASSIFY,mTag,since,mSort);
        NetAsynTask.connectByGet(url + Urls.CLASSIFY, null, req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    if (refresh) {
                        mTopicsBeen.clear();
                        mContentXRecyclerview.refreshFinish();
                    }
                    if (loadMore) {
                        mContentXRecyclerview.loadMoreFinish();
                    }
                    //初始化一个bean用保存本次请求下来的数据
                    List<BeanContent.DataBean.TopicsBean> content = new ArrayList<>();
                    BeanContent beanContent = req.getT();
                    content = beanContent.getData().getTopics();
                    //是否有下一页
                    mPageSize = content.size();
                    if (mPageSize == 20) {
                        since+=20;
                    }
                    // 将每次网络请求的数据添加到总的List
                    mTopicsBeen.addAll(content);
                    //清空为下次请求做准备
                    content.clear();
                    mCentreAdapter.setTag(mSort);

                }
            }

            @Override
            public void onGetFinished() {
                mContentXRecyclerview.showLoading(false);
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
