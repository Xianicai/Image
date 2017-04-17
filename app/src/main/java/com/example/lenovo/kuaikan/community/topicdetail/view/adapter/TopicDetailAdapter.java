package com.example.lenovo.kuaikan.community.topicdetail.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.community.BeanFeeds;
import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;
import com.example.lenovo.kuaikan.community.comment.view.CommentActivity;
import com.example.lenovo.kuaikan.utils.ListUtil;
import com.example.lenovo.kuaikan.utils.StringUtil;
import com.example.lenovo.kuaikan.utils.dateutil.DateUtil;
import com.example.lenovo.kuaikan.widget.SquareImageView;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/17.
 */

public class TopicDetailAdapter extends RecyclerView.Adapter<TopicDetailAdapter.TopicDetailVH> {
    Context mContext;
    List<CommentBean.DataBean.CommentsBean> mComments;
    BeanFeeds.DataBean.FeedsBean feedsBean;

    public TopicDetailAdapter(Context context, List<CommentBean.DataBean.CommentsBean> comments, BeanFeeds.DataBean.FeedsBean feedsBean) {
        mContext = context;
        mComments = comments;
        this.feedsBean = feedsBean;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0) {
            return 0;
        }else {
            return position;
        }
    }

    @Override
    public TopicDetailVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.topics_detail_item_top, parent, false);
            TopicDetailVH vh = new TopicDetailVH(view);
            return vh;
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_comment_item, parent, false);
        TopicDetailVH vh = new TopicDetailVH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(TopicDetailVH holder, int position) {
        if (position ==0) {
            holder.nickName.setText(feedsBean.getUser().getNickname());
            holder.mImgeTopicAvatar.setRounImage(feedsBean.getUser().getAvatar_url());
            holder.mTvContent.setText(feedsBean.getContent().getText());
            String imageBase = feedsBean.getContent().getImage_base();
            List<String> images = feedsBean.getContent().getImages();
            if (StringUtil.isNotEmpty(imageBase) && ListUtil.isNotEmpty(images)) {
                updateViewGroup(holder.mGridlayoutPost, imageBase, images);
            }
            //转化时间格式 MM-dd HH:mm
            String date = DateUtil.formatLongToDates(feedsBean.getUpdated_at());
            holder.mTvUpdateTime.setText(date);
            holder.mLikesCount.setText(feedsBean.getLikes_count() + "");
            holder.mCommentsCount.setText(feedsBean.getComments_count() + "");
            holder.mLayoutComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CommentActivity.class);
                    intent.putExtra("feedId", feedsBean.getFeed_id() + "");
                    mContext.startActivity(intent);
                }
            });
        }else {
            holder.tvUseName.setText(mComments.get(position-1).getUser().getNickname());
            holder.mImageView.setRounImage(mComments.get(position-1).getUser().getAvatar_url());
            //转化时间格式 MM-dd HH:mm
            String date = DateUtil.formatLongToDates(mComments.get(position-1).getCreated_at()*1000);
            holder.mTvCreatTime.setText(date);
            holder.mTvCreatDetails.setText(mComments.get(position-1).getContent());
            holder.mTvLikeNum.setText(mComments.get(position-1).getLikes_count() + "");
        }

    }

    @Override
    public int getItemCount() {
        return mComments.size()+1;
    }

    class TopicDetailVH extends RecyclerView.ViewHolder {
        private final TextView tvUseName;
        private final GlideImageView mImageView;
        private final TextView mTvCreatTime;
        private final TextView mTvCreatDetails;
        private final TextView mTvLikeNum;
        //topView
        private final TextView nickName;
        private final GridLayout mGridlayoutPost;
        private final GlideImageView mImgeTopicAvatar;
        private final TextView mTvContent;
        private final TextView mTvUpdateTime;
        private final TextView mLikesCount;
        private final TextView mCommentsCount;
        private final ImageView mImgCommentNumber;
        private final LinearLayout mLayoutComment;
        public TopicDetailVH(View itemView) {
            super(itemView);
            tvUseName = (TextView) itemView.findViewById(R.id.tv_user_name);
            mImageView = (GlideImageView) itemView.findViewById(R.id.head_glideimageview);
            mTvCreatTime = (TextView) itemView.findViewById(R.id.tv_creat_time);
            mTvCreatDetails = (TextView) itemView.findViewById(R.id.tv_creat_details);
            mTvLikeNum = (TextView) itemView.findViewById(R.id.tv_like_num);
            //topView
            nickName = (TextView) itemView.findViewById(R.id.tv_nickName);
            mImgeTopicAvatar = (GlideImageView) itemView.findViewById(R.id.imge_topic_avatar);
            mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
            mTvUpdateTime = (TextView) itemView.findViewById(R.id.tv_updateTime);
            mLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_topic);
            mCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_topic);
            mGridlayoutPost = (GridLayout) itemView.findViewById(R.id.gridlayout_post);
            mImgCommentNumber = (ImageView) itemView.findViewById(R.id.img_commentNumber);
            mLayoutComment = (LinearLayout) itemView.findViewById(R.id.layout_comment);
        }
    }
    /**
     * 动态添加控件
     *
     * @param mGridlayoutPost 图片集合
     */
    private void updateViewGroup(GridLayout mGridlayoutPost, final String imageBase, final List<String> images) {
        mGridlayoutPost.removeAllViews();//清空子视图 防止原有的子视图影响
        int columnCount = mGridlayoutPost.getColumnCount();//得到列数
        if (images.size() == 1) {
            SquareImageView imageView = new SquareImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setDefaultImage(R.mipmap.ic_common_placeholder_l_750);
            //设置imageView的固定宽高
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(650, 650));
            layoutParams.rowSpec = GridLayout.spec(0);
            layoutParams.columnSpec = GridLayout.spec(0);
            layoutParams.setMargins(5, 5, 5, 5);
            mGridlayoutPost.addView(imageView, layoutParams);
            imageView.setImage(imageBase + images.get(0));
//            setListener(imageBase, (ArrayList<String>) images, imageView, 0);
        } else if (images.size() == 2 || images.size() == 4) {
            //重新设置mGridlayoutPost的宽高
            ViewGroup.LayoutParams params;
            params = mGridlayoutPost.getLayoutParams();
            params.width = GridLayout.LayoutParams.WRAP_CONTENT;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            mGridlayoutPost.setLayoutParams(params);
            //如果是2张或者4张 设列数为2
            columnCount = 2;
            //遍历集合 动态添加
            for (int i = 0; i < images.size(); i++) {
                GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
                GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount, 1.0f);//列数 列宽的比例 weight=1
                SquareImageView imageView = new SquareImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setDefaultImage(R.mipmap.ic_common_placeholder_l_750);
                //设置imageView的固定宽高
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(325, 325));
                layoutParams.rowSpec = rowSpec;
                layoutParams.columnSpec = columnSpec;
                layoutParams.setMargins(5, 5, 5, 5);
                mGridlayoutPost.addView(imageView, layoutParams);
                imageView.setImage(imageBase + images.get(i));
//                setListener(imageBase, (ArrayList<String>) images, imageView, i);
            }
        } else {
            //遍历集合 动态添加
            for (int i = 0; i < images.size(); i++) {
                GridLayout.Spec rowSpec = GridLayout.spec(i / columnCount);//行数
                GridLayout.Spec columnSpec = GridLayout.spec(i % columnCount, 1.0f);//列数 列宽的比例 weight=1
                SquareImageView imageView = new SquareImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setDefaultImage(R.mipmap.ic_common_placeholder_l_750);
                //由于宽（即列）已经定义权重比例 宽设置为0 保证均分
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));
                layoutParams.rowSpec = rowSpec;
                layoutParams.columnSpec = columnSpec;
                layoutParams.setMargins(5, 5, 5, 5);
                mGridlayoutPost.addView(imageView, layoutParams);
                imageView.setImage(imageBase + images.get(i));
//                setListener(imageBase, (ArrayList<String>) images, imageView, i);
            }
        }
    }
}
