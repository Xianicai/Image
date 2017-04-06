package com.example.lenovo.kuaikan.discover;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;
import com.example.lenovo.kuaikan.widget.XRecyclerview;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class RecommendFragment extends BaseFragment {
    @BindView(R.id.banner_guide_content)
    BGABanner mBannerGuideContent;
    @BindView(R.id.tv_rank)
    GlideImageView mTvRank;
    @BindView(R.id.tv_new)
    GlideImageView mTvNew;
    @BindView(R.id.tv_finish)
    GlideImageView mTvFinish;
    @BindView(R.id.tv_classify)
    GlideImageView mTvClassify;
    @BindView(R.id.recomm_xrecyclerview)
    XRecyclerview mRecommXrecyclerview;
    private List<BeanRecomm.DataBean.InfosBean> mInfosBeen;
    private RecommAdapter mRecommAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.recommend_fragment;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecommXrecyclerview.setLayoutManager(linearLayoutManager);
        mRecommXrecyclerview.setItemAnimator(new DefaultItemAnimator());
        mRecommXrecyclerview.setOnRefreshLoadMore(new XRecyclerview.OnRefreshLoadMore() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });

        mInfosBeen = new ArrayList<>();
        mRecommAdapter = new RecommAdapter(getActivity(),mInfosBeen);
        mRecommXrecyclerview.setAdapter(mRecommAdapter);
        getServerData();

    }

    private void getServerData() {
        mRecommXrecyclerview.showLoading(true);
        final ReqRecomm req = new ReqRecomm();
        NetAsynTask.connectByGet(Urls.DISCOVER_RECOMMEND, null, req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    BeanRecomm beanRecomm = req.getT();
                    List<BeanRecomm.DataBean.InfosBean> infosBeanList = beanRecomm.getData().getInfos();
                    List<BeanRecomm.DataBean.InfosBean.BannersBean> bannerUrls = infosBeanList.get(0).getBanners();
                    //轮播图加载
                    initBanner(bannerUrls);
                    for (int i = 1; i <infosBeanList.size() ; i++) {
                        if (i == 8) {
                            continue;
                        }
                        mInfosBeen.add(infosBeanList.get(i));
                    }
                    mRecommAdapter.notifyDataSetChanged();
//                    //初始化一个bean用保存本次请求下来的数据
//                    List<BeanFeeds.DataBean.FeedsBean> feeds = new ArrayList<>();
//                    BeanFeeds beanFeeds = req.getT();
//                    feeds = beanFeeds.getData().getFeeds();
//                    //是否有下一页
//                    mPageSize = feeds.size();
//                    if (mPageSize == 20) {
//                        mPageNumber++;
//                    }
//                    // 将每次网络请求的数据添加到总的List
//                    mFeedsBeen.addAll(feeds);
//                    //清空为下次请求做准备
//                    feeds.clear();
//                    //实例化一个MainAdapter对象
//                    mTopicsAdapter.notifyDataSetChanged();
//                    if (refresh) {
//                        mTopicsXRecyclerview.refreshFinish();
//                    }
//                    if (loadMore) {
//                        mTopicsXRecyclerview.loadMoreFinish();
//                    }
                }
            }

            @Override
            public void onGetFinished() {
                mRecommXrecyclerview.showLoading(false);

            }

            @Override
            public void onGetFaild() {

            }

            @Override
            public void onGetError() {

            }
        });
    }
    private void initBanner( List<BeanRecomm.DataBean.InfosBean.BannersBean> bannerUrls) {
        List<String> mBannerUrls; mBannerUrls = new ArrayList<String>();
        for (int i = 0; i <bannerUrls.size() ; i++) {
            mBannerUrls.add(bannerUrls.get(i).getPic());
        }

        List<View> views = new ArrayList<>();
        for (int i = 0; i < mBannerUrls.size(); i++) {
            GlideImageView mImageView = new GlideImageView(getActivity());
            mImageView.setDefaultImage(R.mipmap.ic_common_placeholder_l_750);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageView.setImage(mBannerUrls.get(i));
            views.add(mImageView);
        }
        mBannerGuideContent.setData(views);
    }

}
