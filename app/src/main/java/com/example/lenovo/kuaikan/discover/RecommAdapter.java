package com.example.lenovo.kuaikan.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.NumberUtil;
import com.example.lenovo.kuaikan.widget.AcrossImageTv;
import com.example.lenovo.kuaikan.widget.ImgTvlayout;
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

    public RecommAdapter(Context context, List<BeanRecomm.DataBean.InfosBean> mInfosBeen) {
        mContext = context;
        this.mInfosBeen = mInfosBeen;
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
            case 2:
                mView = 2;
                break;
            case 3:
                mView = 1;
                break;
            case 4:
                mView = 2;
                break;
            case 5:
                mView = 2;
                break;
            case 6:
                mView = 3;
                break;
            case 7:
                mView = 2;
                break;
            case 8:
                mView = 2;
                break;
            case 9:
                mView = 2;
                break;
            case 10:
                mView = 3;
                break;
            case 11:
                mView = 2;
                break;
        }
        return mView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recomm_fragment_item_bgabanner, parent, false);
                return new RecommAdapter.RecommBannerViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recomm_fragment_item_rank, parent, false);
                return new RecommAdapter.RecommRankViewHolder(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recom_item_across_imgtv, parent, false);
                return new RecommAdapter.RecommAcrossImgTvViewHolder(view);


        }
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recomm_fragment_item_imgtv, parent, false);
        return new RecommAdapter.RecommImgTvViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (position) {
            case 0: //第一个item
                initBanner(((RecommBannerViewHolder) holder).mBanner, mInfosBeen.get(position).getBanners());
                break;
            case 1:
                initRank(((RecommRankViewHolder) holder).mGridlayout, mInfosBeen.get(position).getBanners());
                break;
            case 2:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTv(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
            case 3:
                initBusiness(((RecommRankViewHolder) holder).mGridlayout, mInfosBeen.get(position).getBanners());
                break;
            case 4:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTvThree(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
            case 5:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTv(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
            case 6:
                ((RecommAcrossImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initAcrossImgTv(((RecommAcrossImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics(),position);
                break;
            case 7:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTv(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
            case 8:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTvThree(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
            case 9:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTvThree(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
            case 10:
                ((RecommAcrossImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initAcrossImgTv(((RecommAcrossImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics(),position);
                break;
            case 11:
                ((RecommImgTvViewHolder) holder).mTvTitle.setText(mInfosBeen.get(position).getTitle());
                initImgTvThree(((RecommImgTvViewHolder) holder).mGridlayout, mInfosBeen.get(position).getTopics());
                break;
        }


    }

    private void initAcrossImgTv(GridLayout gridlayout, List<BeanRecomm.DataBean.InfosBean.TopicsBean> topics,int position) {
        gridlayout.removeAllViews();//清空子视图 防止原有的子视图影响
        gridlayout.setColumnCount(1);
        int columnCount = 1;//得到列数
        //遍历集合 动态添加
        for (int i = 0; i < topics.size(); i++) {
            GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
            GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount);//列数 列宽的比例 weight=1
            AcrossImageTv acrossImageTv = new AcrossImageTv(mContext);
            acrossImageTv.setDefaultImage(R.mipmap.ic_common_placeholder_ss);
            if (position ==10) {
                acrossImageTv.addLayout(2);
            }else {
                acrossImageTv.addLayout(1);
            }
            //由于宽（即列）已经定义权重比例 宽设置为0 保证均分
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.rowSpec = rowSpec;
            layoutParams.columnSpec = columnSpec;
            layoutParams.setMargins(30, 10, 30, 10);
            gridlayout.addView(acrossImageTv, layoutParams);
            acrossImageTv.setImage(topics.get(i).getPic());

            if (position ==10) {
                acrossImageTv.setLayoutCommentTitle(topics.get(i).getRecommended_text());
                acrossImageTv.setLayoutCommentStyle(topics.get(i).getTitle());
                acrossImageTv.setLayoutCommentCommentNum(NumberUtil.buildTenThousand(topics.get(i).getLikes_count()));
            }else {
                acrossImageTv.setLayoutLabeName(topics.get(i).getTitle());
                acrossImageTv.setLayoutLabeLable(topics.get(i).getLabel_text());
                acrossImageTv.setLayoutLabeFrome(topics.get(i).getRecommended_text());
            }

        }
    }

    //三张上图下文
    private void initImgTvThree(GridLayout gridlayout, List<BeanRecomm.DataBean.InfosBean.TopicsBean> beanList) {
        gridlayout.removeAllViews();//清空子视图 防止原有的子视图影响
        gridlayout.setColumnCount(3);
        int columnCount = 3;//得到列数
        //遍历集合 动态添加
        for (int i = 0; i < beanList.size(); i++) {
            GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
            GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount, 1.0f);//列数 列宽的比例 weight=1
            ImgTvlayout imgTvlayout = new ImgTvlayout(mContext);
            imgTvlayout.setDefaultImage(R.mipmap.ic_common_placeholder_ss);
            imgTvlayout.setScaleType(1);
            imgTvlayout.setImageWidthHeight(400, 530);
            //由于宽（即列）已经定义权重比例 宽设置为0 保证均分
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.rowSpec = rowSpec;
            layoutParams.columnSpec = columnSpec;
            layoutParams.setMargins(0, 20, 0, 0);
            gridlayout.addView(imgTvlayout, layoutParams);
            imgTvlayout.setImage(beanList.get(i).getPic());
            imgTvlayout.setTextNmae(beanList.get(i).getRecommended_text());
            imgTvlayout.setTextInfo(beanList.get(i).getTitle());
        }
    }

    //电商banner
    private void initBusiness(GridLayout mGridlayout, List<BeanRecomm.DataBean.InfosBean.BannersBean> bannerUrls) {
        mGridlayout.removeAllViews();//清空子视图 防止原有的子视图影响
        int columnCount = mGridlayout.getColumnCount();//得到列数
        //遍历集合 动态添加
        for (int i = 0; i < 1; i++) {
            GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
            GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount, 1.0f);//列数 列宽的比例 weight=1
            GlideImageView imageView = new GlideImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(320,105));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setDefaultImage(R.mipmap.ic_common_placeholder_ss);
            //由于宽（即列）已经定义权重比例 宽设置为0 保证均分
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.rowSpec = rowSpec;
            layoutParams.columnSpec = columnSpec;
            layoutParams.setMargins(25, 25, 25, 25);
            mGridlayout.addView(imageView, layoutParams);
            imageView.setImage(bannerUrls.get(i).getPic());
        }
    }

    private void initImgTv(GridLayout gridlayout, List<BeanRecomm.DataBean.InfosBean.TopicsBean> beanList) {
        gridlayout.removeAllViews();//清空子视图 防止原有的子视图影响
        gridlayout.setColumnCount(2);
        int columnCount = 2;//得到列数
        //遍历集合 动态添加
        for (int i = 0; i < beanList.size(); i++) {
            GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
            GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount, 1.0f);//列数 列宽的比例 weight=1
            ImgTvlayout imgTvlayout = new ImgTvlayout(mContext);
            imgTvlayout.setDefaultImage(R.mipmap.ic_common_placeholder_ss);
            imgTvlayout.setScaleType(1);
            //由于宽（即列）已经定义权重比例 宽设置为0 保证均分
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.rowSpec = rowSpec;
            layoutParams.columnSpec = columnSpec;
            if (i == 0 || i == 2) {
                layoutParams.setMargins(45, 5, 0, 10);
            } else {
                layoutParams.setMargins(10, 5, 0, 10);
            }

            gridlayout.addView(imgTvlayout, layoutParams);
            imgTvlayout.setImage(beanList.get(i).getPic());
            imgTvlayout.setTextNmae(beanList.get(i).getDescription());
            imgTvlayout.setTextInfo(beanList.get(i).getTitle());
        }
    }

    //排行榜
    private void initRank(GridLayout mGridlayout, List<BeanRecomm.DataBean.InfosBean.BannersBean> bannerUrls) {
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
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(0, 255));
            layoutParams.rowSpec = rowSpec;
            layoutParams.columnSpec = columnSpec;
            layoutParams.setMargins(20, 20, 20, 20);
            mGridlayout.addView(imageView, layoutParams);
            imageView.setImage(bannerUrls.get(i).getPic());
        }
    }


    @Override
    public int getItemCount() {
        return mInfosBeen.size();
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

    class RecommImgTvViewHolder extends RecyclerView.ViewHolder {
        private final GridLayout mGridlayout;
        private final TextView mTvTitle;

        public RecommImgTvViewHolder(View itemView) {
            super(itemView);
            //第三个item
            mGridlayout = (GridLayout) itemView.findViewById(R.id.gridlayout);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);

        }
    }

    class RecommAcrossImgTvViewHolder extends RecyclerView.ViewHolder {
        private final GridLayout mGridlayout;
        private final TextView mTvTitle;

        public RecommAcrossImgTvViewHolder(View itemView) {
            super(itemView);
            //第三个item
            mGridlayout = (GridLayout) itemView.findViewById(R.id.gridlayout);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);

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
