package com.example.lenovo.kuaikan.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by Zhanglibin on 2017/4/5.
 */

public class RecommAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<BeanRecomm.DataBean.InfosBean> mInfosBeen;
    public final static int TYPE_ONE = 0;//Item的第一种布局
    public final static int TYPE_TWO = 1;//Item的第二种布局

    public RecommAdapter(Context context, List<BeanRecomm.DataBean.InfosBean> mInfosBeen) {
        mContext = context;
        this.mInfosBeen = mInfosBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recomm_fragment_item_bgabanner, parent, false);
                viewHolder = new RecommAdapter.RecommBannerViewHolder(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recomm_fragment_item_rank, parent, false);
                viewHolder = new RecommAdapter.RecommRankViewHolder(view);
                break;
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecommBannerViewHolder) {
            initBanner(((RecommBannerViewHolder) holder).mBanner,mInfosBeen.get(position).getBanners());
            return;
        }
        if (holder instanceof RecommRankViewHolder) {
            initRank(((RecommRankViewHolder)holder).mGridlayout,position);
            return;
        }
//        switch (position) {
//            case 0: //第一个item
//                initBanner(holder.mBanner, mInfosBeen.get(position).getBanners());
//                break;
//            case 1:
//                initRank(holder, position);
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//        }


    }

    //第二个item
    private void initRank(GridLayout mGridlayout, int position) {
        mGridlayout.removeAllViews();//清空子视图 防止原有的子视图影响
        int columnCount = mGridlayout.getColumnCount();//得到列数
        //遍历集合 动态添加
        for (int i = 0; i < 4; i++) {
            GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
            GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount, 1.0f);//列数 列宽的比例 weight=1
            GlideImageView imageView = new GlideImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setDefaultImage(R.mipmap.ic_common_placeholder_ss);
            //由于宽（即列）已经定义权重比例 宽设置为0 保证均分
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.rowSpec = rowSpec;
            layoutParams.columnSpec = columnSpec;
            layoutParams.setMargins(5, 5, 5, 5);
            mGridlayout.addView(imageView, layoutParams);
            imageView.setImage(mInfosBeen.get(position).getBanners().get(i).getPic());
        }
    }


    @Override
    public int getItemCount() {
        return mInfosBeen.size();
    }

    @Override
    public int getItemViewType(int position) {
        int mView = 0;
        switch (position) {
            case 0:
                mView = 0;
                break;
            case 1:
                mView = 1;
                break;
        }
        return mView;
    }

    class RecommBannerViewHolder extends RecyclerView.ViewHolder {
        private final BGABanner mBanner;
        public RecommBannerViewHolder(View itemView) {
            super(itemView);
            //第一个item
            mBanner = (BGABanner) itemView.findViewById(R.id.banner_guide_content);

        }
    }

    class RecommRankViewHolder extends RecyclerView.ViewHolder {
        private final GridLayout mGridlayout;
        public RecommRankViewHolder(View itemView) {
            super(itemView);
            //第二个item
            mGridlayout = (GridLayout) itemView.findViewById(R.id.gridlayout_post);

        }
    }

    private void initBanner(BGABanner banner, List<BeanRecomm.DataBean.InfosBean.BannersBean> bannerUrls) {
        List<String> mBannerUrls;
        mBannerUrls = new ArrayList<String>();
        for (int i = 0; i < bannerUrls.size(); i++) {
            mBannerUrls.add(bannerUrls.get(i).getPic());
        }

        List<View> views = new ArrayList<>();
        for (int i = 0; i < mBannerUrls.size(); i++) {
            GlideImageView mImageView = new GlideImageView(mContext);
            mImageView.setDefaultImage(R.mipmap.ic_common_placeholder_l_750);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageView.setImage(mBannerUrls.get(i));
            views.add(mImageView);
        }
        banner.setData(views);
        //banner的点击事件
        banner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner bgaBanner, View view, Object o, int i) {

            }
        });
    }
}
