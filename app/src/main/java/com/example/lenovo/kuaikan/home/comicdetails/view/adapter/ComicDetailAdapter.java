package com.example.lenovo.kuaikan.home.comicdetails.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicCommentBean;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.utils.Animators;
import com.example.lenovo.kuaikan.utils.NumberUtil;
import com.example.lenovo.kuaikan.utils.dateutil.DateUtil;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicDetailAdapter extends RecyclerView.Adapter<ComicDetailAdapter.ComicDetailHV> {
    private Context mContext;
    private List<ComicCommentBean.DataBean.ReviewsBean> reviews;
    private ComicDetailBean.DataBean dataBean = new ComicDetailBean.DataBean();
    private String mDescription;
    private String mAvatarUrl;
    private String mNickname;
    private String mFollowNum;
    private String mHotNum;

    public ComicDetailAdapter(Context context, List<ComicCommentBean.DataBean.ReviewsBean> reviews) {
        mContext = context;
        this.reviews = reviews;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return position;

        }
    }

    @Override
    public ComicDetailHV onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.comic_detail_top_info, parent, false);
            ComicDetailHV vh = new ComicDetailHV(view);
            return vh;
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_comic_detial_item, parent, false);
        ComicDetailHV vh = new ComicDetailHV(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(final ComicDetailHV holder, final int position) {
        if (position == 0) {
            holder.mTvInfo.setText(mDescription);
            holder.mImageAuthorHead.setRounImage(mAvatarUrl);
            holder.mTvAuthorName.setText(mNickname);
            holder.mTvFollow.setText("   "+mFollowNum+"人已关注");
            holder.mTvHot.setText("   总热度"+mHotNum);
        } else {
            holder.mImageAuthor.setRounImage(reviews.get(position).getUser().getAvatar_url());
            holder.mTvName.setText(reviews.get(position).getUser().getNickname());
            holder.mTvCreatTime.setText(DateUtil.formatLongToDates(reviews.get(position).getCreated_at()));
            holder.mTvlikeNum.setText(reviews.get(position).getLikes_count() + "");
            holder.mTvDetail.setText(reviews.get(position).getContent());
            holder.mImageLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (reviews.get(position).isIs_liked()) {
                        holder.mImageLike.setImageResource(R.mipmap.ic_common_praise_normal);
                        reviews.get(position).setLikes_count(reviews.get(position).getLikes_count() - 1);
                    } else {
                        holder.mImageLike.setImageResource(R.mipmap.ic_common_praise_highlighted_like_pressed);
                        reviews.get(position).setLikes_count(reviews.get(position).getLikes_count() + 1);
                    }
                    reviews.get(position).setIs_liked(!reviews.get(position).isIs_liked());
//                点赞动画
                    Animators.doLikeAnimator(holder.mImageLike, ComicDetailAdapter.this);
                }
            });
        }

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
        private final TextView mTvInfo;
        private final GlideImageView mImageAuthorHead;
        private final TextView mTvAuthorName;
        private final TextView mTvFollow;
        private final TextView mTvHot;
        private final ImageView mImageLike;

        public ComicDetailHV(View itemView) {
            super(itemView);
            mImageAuthor = (GlideImageView) itemView.findViewById(R.id.image_author);
            mTvCreatTime = (TextView) itemView.findViewById(R.id.tv_creat_time);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvlikeNum = (TextView) itemView.findViewById(R.id.tv_like_num);
            mTvDetail = (TextView) itemView.findViewById(R.id.tv_detail);
            mImageLike = (ImageView) itemView.findViewById(R.id.image_like);
//            作者简介
            mTvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            mImageAuthorHead = (GlideImageView) itemView.findViewById(R.id.image_author_head);
            mTvAuthorName = (TextView) itemView.findViewById(R.id.tv_author_name);
            mTvFollow = (TextView) itemView.findViewById(R.id.tv_follow);
            mTvHot = (TextView) itemView.findViewById(R.id.tv_hot);

        }
    }

    public void setTopData(ComicDetailBean.DataBean dataBean) {
        this.dataBean = dataBean;
        mDescription = dataBean.getDescription();
        mAvatarUrl = dataBean.getUser().getAvatar_url();
        mNickname = dataBean.getUser().getNickname();
        mHotNum = NumberUtil.buildNumber(dataBean.getView_count());
        mFollowNum = NumberUtil.buildNumber(dataBean.getFav_count());
    }
}
