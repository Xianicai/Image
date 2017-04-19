package com.example.lenovo.kuaikan.discover;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.base.ServerData;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;
import com.example.lenovo.kuaikan.widget.XRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class RecommendFragment extends BaseFragment {
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
                getServerData(true);
            }

            @Override
            public void onLoadMore() {

            }
        });

        mInfosBeen = new ArrayList<>();
        mRecommAdapter = new RecommAdapter(getActivity(), mInfosBeen);
        mRecommXrecyclerview.setAdapter(mRecommAdapter);
        getServerData(false);

    }

    private void getServerData(final boolean isRefresh) {
        mRecommXrecyclerview.showLoading(true);
        final ReqRecomm req = new ReqRecomm();
        NetAsynTask.connectByGet(Urls.DISCOVER_RECOMMEND, null, req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    if (isRefresh) {
                        mRecommXrecyclerview.refreshFinish();
                    }

                    ReqRecomm reqRecomm = new ReqRecomm();
                    reqRecomm.getNetData(ServerData.DISCOVER_RECOMMEND);

                    BeanRecomm beanRecomm = reqRecomm.getT();
                    mInfosBeen.clear();
                    mInfosBeen.addAll(beanRecomm.getData().getInfos());
                    mRecommAdapter.notifyDataSetChanged();
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


}
