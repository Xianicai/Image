package com.example.lenovo.kuaikan.community;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.ListUtil;
import com.example.lenovo.kuaikan.utils.StringUtil;
import com.example.lenovo.kuaikan.utils.dateutil.DateUtil;
import com.example.lenovo.kuaikan.widget.SquareImageView;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/1.
 */

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.TopicsViewHolder> {
    Context mContext;
    List<BeanFeeds.DataBean.FeedsBean> mFeedsBeen;

    public TopicsAdapter(Context context, List<BeanFeeds.DataBean.FeedsBean> mFeedsBeen) {
        mContext = context;
        this.mFeedsBeen = mFeedsBeen;
    }

    @Override
    public TopicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.topics_fragment_item, parent, false);
        TopicsViewHolder topicsViewHolder = new TopicsViewHolder(view);
        return topicsViewHolder;
    }

    @Override
    public void onBindViewHolder(TopicsViewHolder holder, int position) {
        holder.nickName.setText(mFeedsBeen.get(position).getUser().getNickname());
        holder.mImgeTopicAvatar.setRounImage(mFeedsBeen.get(position).getUser().getAvatar_url());
        holder.mTvContent.setText(mFeedsBeen.get(position).getContent().getText());
        String imageBase = mFeedsBeen.get(position).getContent().getImage_base();
        List<String> images = mFeedsBeen.get(position).getContent().getImages();
        if (StringUtil.isNotEmpty(imageBase) && ListUtil.isNotEmpty(images)) {
            updateViewGroup(holder.mGridlayoutPost,imageBase,images);

//            holder.mImgeTopic.setImage(imageBase + images.get(0));
        }
        //转化时间格式 MM-dd HH:mm
        String date = DateUtil.formatLongToDates(mFeedsBeen.get(position).getUpdated_at());
        holder.mTvUpdateTime.setText(date);
        holder.mLikesCount.setText(mFeedsBeen.get(position).getLikes_count() + "");
        holder.mCommentsCount.setText(mFeedsBeen.get(position).getComments_count() + "");

    }

    @Override
    public int getItemCount() {
        return mFeedsBeen.size();
    }

    public class TopicsViewHolder extends RecyclerView.ViewHolder {


        private final TextView nickName;
        private final GridLayout mGridlayoutPost;
        private final GlideImageView mImgeTopicAvatar;
        private final TextView mTvContent;
//        private final SquareImageView mImgeTopic;
        private final TextView mTvUpdateTime;
        private final TextView mLikesCount;
        private final TextView mCommentsCount;

        public TopicsViewHolder(View itemView) {
            super(itemView);
            //初始化控件
            nickName = (TextView) itemView.findViewById(R.id.tv_nickName);
            mImgeTopicAvatar = (GlideImageView) itemView.findViewById(R.id.imge_topic_avatar);
            mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
//            mImgeTopic = (SquareImageView) itemView.findViewById(R.id.imge_topic);
            mTvUpdateTime = (TextView) itemView.findViewById(R.id.tv_updateTime);
            mLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_topic);
            mCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_topic);
            mGridlayoutPost = (GridLayout) itemView.findViewById(R.id.gridlayout_post);



        }
    }

    /**
     * 动态添加控件
     *
     * @param mGridlayoutPost 图片集合
     */
    private void updateViewGroup(GridLayout mGridlayoutPost, String imageBase, List<String> images) {
        mGridlayoutPost.removeAllViews();//清空子视图 防止原有的子视图影响
        int columnCount=mGridlayoutPost.getColumnCount();//得到列数
        if (images.size()==1) {
            SquareImageView imageView = new SquareImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setDefaultImage(R.mipmap.ic_common_placeholder_l_750);
            //设置imageView的固定宽高
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(650, 650));
            layoutParams.rowSpec = GridLayout.spec(0);
            layoutParams.columnSpec = GridLayout.spec(0);
            layoutParams.setMargins(5, 5, 5, 5);
            mGridlayoutPost.addView(imageView, layoutParams);
            imageView.setImage(imageBase+images.get(0));
        }else if (images.size()==2||images.size()==4){
            //重新设置mGridlayoutPost的宽高
            ViewGroup.LayoutParams params;
            params=  mGridlayoutPost.getLayoutParams();
            params.width= GridLayout.LayoutParams.WRAP_CONTENT;
            params.height=GridLayout.LayoutParams.WRAP_CONTENT;
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
                imageView.setImage(imageBase+images.get(i));
            }
        }else {
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
                imageView.setImage(imageBase+images.get(i));
            }
        }
        }

}

