package com.example.lenovo.kuaikan.home.comicdetails.view.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicread.view.ReadActivity;
import com.example.lenovo.kuaikan.utils.NumberUtil;
import com.example.lenovo.kuaikan.utils.dateutil.DateUtil;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicListAdapter extends RecyclerView.Adapter<ComicListAdapter.ComicListVH> {
    Context mContext;
    private final List<ComicDetailBean.DataBean.ComicsBean> mComics;
    private String topTitle;

    public ComicListAdapter(Context context, List<ComicDetailBean.DataBean.ComicsBean> mComics) {
        mContext = context;
        this.mComics = mComics;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public ComicListVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.comic_list_item_top, parent, false);
            ComicListVH vh = new ComicListVH(view);
            return vh;
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.comic_list_item, parent, false);
        ComicListVH vh = new ComicListVH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ComicListVH holder, final int position) {
        if (position == 0) {
            holder.mTvMsg.setText(topTitle);
        } else {
            holder.mImageCover.setImage(mComics.get(position-1).getCover_image_url());
            holder.mTvTitle.setText(mComics.get(position-1).getTitle());
            holder.mTvCreatTime.setText(DateUtil.formatIntToDates(mComics.get(position-1).getCreated_at()*1000));
            holder.mTvLikeNum.setText("   "+NumberUtil.buildTenThousand(mComics.get(position-1).getLikes_count()));
            holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReadActivity.toRead(mContext,mComics.get(position-1).getId()+"");
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mComics.size()+1;
    }

    class ComicListVH extends RecyclerView.ViewHolder {

        private final GlideImageView mImageCover;
        private final TextView mTvTitle;
        private final TextView mTvCreatTime;
        private final TextView mTvLikeNum;
        private final TextView mTvMsg;
        private final ConstraintLayout mLayoutItem;

        public ComicListVH(View itemView) {
            super(itemView);
            mImageCover = (GlideImageView) itemView.findViewById(R.id.image_cover);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mTvCreatTime = (TextView) itemView.findViewById(R.id.tv_creat_time);
            mTvLikeNum = (TextView) itemView.findViewById(R.id.tv_like_num);
            mTvMsg = (TextView) itemView.findViewById(R.id.tv_msg);
            mLayoutItem = (ConstraintLayout) itemView.findViewById(R.id.layout_item);

        }
    }

    public void setTopData(String topTitle) {
        this.topTitle = topTitle;
        notifyDataSetChanged();
    }
}
