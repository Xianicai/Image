package com.example.lenovo.kuaikan.home.comicdetails.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicCommentBean;
import com.example.lenovo.kuaikan.utils.dateutil.DateUtil;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicDetailAdapter extends RecyclerView.Adapter<ComicDetailAdapter.ComicDetailHV> {
    Context mContext;
    List<ComicCommentBean.DataBean.ReviewsBean> reviews;
    public ComicDetailAdapter(Context context, List<ComicCommentBean.DataBean.ReviewsBean> reviews) {
        mContext = context;
        this.reviews = reviews;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0) {
            return 0;
        }else {
            return position;

        }
    }

    @Override
    public ComicDetailHV onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (parent != null) {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.comic_detail_top_info, parent, false);
//            ComicDetailHV vh = new ComicDetailHV(view);
//            return vh;
//        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_comic_detial_item, parent, false);
        ComicDetailHV vh = new ComicDetailHV(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(ComicDetailHV holder, int position) {
        holder.mImageAuthor.setRounImage(reviews.get(position).getUser().getAvatar_url());
        holder.mTvName.setText(reviews.get(position).getUser().getNickname());
        holder.mTvCreatTime.setText(DateUtil.formatLongToDates(reviews.get(position).getCreated_at()));
        holder.mTvlikeNum.setText("   "+reviews.get(position).getLikes_count()+"");
        holder.mTvDetail.setText(reviews.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ComicDetailHV extends RecyclerView.ViewHolder {

        private final GlideImageView mImageAuthor;
        private final TextView mTvCreatTime;
        private final TextView mTvName;
        private final TextView mTvlikeNum;
        private final TextView mTvDetail;

        public ComicDetailHV(View itemView) {
            super(itemView);
            mImageAuthor = (GlideImageView) itemView.findViewById(R.id.image_author);
            mTvCreatTime = (TextView) itemView.findViewById(R.id.tv_creat_time);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvlikeNum = (TextView) itemView.findViewById(R.id.tv_like_num);
            mTvDetail = (TextView) itemView.findViewById(R.id.tv_detail);
        }
    }
}
