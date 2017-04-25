package com.example.lenovo.kuaikan.community.comment.view.adpater;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.utils.Animators;
import com.example.lenovo.kuaikan.utils.dateutil.DateUtil;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class CommentHotAdapter extends RecyclerView.Adapter<CommentHotAdapter.CommenterViewHolder> {
    List<CommentBean.CommentsBean> mComments;

    public CommentHotAdapter(List<CommentBean.CommentsBean> mComments, Context context) {
        this.mComments = mComments;
        mContext = context;
    }

    Context mContext;

    @Override
    public CommenterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_comment_item, viewGroup, false);
        CommenterViewHolder viewHolder = new CommenterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CommenterViewHolder holder, final int i) {
        holder.tvUseName.setText(mComments.get(i).getUser().getNickname());
        holder.mImageView.setRounImage(mComments.get(i).getUser().getAvatar_url());
        //转化时间格式 MM-dd HH:mm
        String date = DateUtil.formatLongToDates(mComments.get(i).getCreated_at() * 1000);
        holder.mTvCreatTime.setText(date);
        holder.mTvCreatDetails.setText(mComments.get(i).getContent());
        holder.mTvLikeNum.setText(mComments.get(i).getLikes_count() + "");
        holder.mImageCommentLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mComments.get(i).isIs_liked()) {
                    holder.mImageCommentLike.setImageResource(R.mipmap.ic_common_praise_normal);
                    mComments.get(i).setLikes_count(mComments.get(i).getLikes_count() - 1);
                } else {
                    holder.mImageCommentLike.setImageResource(R.mipmap.ic_common_praise_highlighted_like_pressed);
                    mComments.get(i).setLikes_count(mComments.get(i).getLikes_count() + 1);
                }
                mComments.get(i).setIs_liked(!mComments.get(i).isIs_liked());
//                点赞动画
                Animators.doLikeAnimator(holder.mImageCommentLike, CommentHotAdapter.this);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class CommenterViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvUseName;
        private final GlideImageView mImageView;
        private final TextView mTvCreatTime;
        private final TextView mTvCreatDetails;
        private final TextView mTvLikeNum;
        private final ConstraintLayout mConstraintLayout;
        private final ImageView mImageCommentLike;

        public CommenterViewHolder(View itemView) {
            super(itemView);
            tvUseName = (TextView) itemView.findViewById(R.id.tv_user_name);
            mImageView = (GlideImageView) itemView.findViewById(R.id.head_glideimageview);
            mTvCreatTime = (TextView) itemView.findViewById(R.id.tv_creat_time);
            mTvCreatDetails = (TextView) itemView.findViewById(R.id.tv_creat_details);
            mTvLikeNum = (TextView) itemView.findViewById(R.id.tv_like_num);
            mConstraintLayout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
            mImageCommentLike = (ImageView) itemView.findViewById(R.id.image_comment_like);
        }
    }
}
