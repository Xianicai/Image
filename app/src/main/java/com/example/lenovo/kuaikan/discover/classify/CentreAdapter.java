package com.example.lenovo.kuaikan.discover.classify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicdetails.view.ComicDetailActivity;
import com.example.lenovo.kuaikan.utils.NumberUtil;
import com.example.lenovo.kuaikan.utils.StringUtil;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/2.
 */

class CentreAdapter extends RecyclerView.Adapter<CentreAdapter.ContentViewHolder> {
    private Context mContext;
    private List<BeanContent.DataBean.TopicsBean> list;
    private String mSort;

    public CentreAdapter(Context context, List<BeanContent.DataBean.TopicsBean> list, String mSort) {
        mContext = context;
        this.list = list;
        this.mSort = mSort;
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_fragment_item, parent, false);
        ContentViewHolder viewHolder = new ContentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, final int position) {
        holder.mImageVertical.setImage(list.get(position).getVertical_image_url());
        holder.mTvTitle.setText(list.get(position).getTitle());
        holder.mTvNickname.setText(list.get(position).getUser().getNickname());
        holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComicDetailActivity.toDetail(mContext,list.get(position).getId()+"");
            }
        });
        if (StringUtil.isNotBlank(mSort) && StringUtil.equals("1", mSort)) {
            holder.mRecLayout.setVisibility(View.VISIBLE);
            holder.mLikesContent.setText(NumberUtil.buildTenThousand(list.get(position).getLikes_count()));
            holder.mCommentsCount.setText(NumberUtil.buildTenThousand(list.get(position).getComments_count()));
        } else if (StringUtil.isNotBlank(mSort) && StringUtil.equals("2", mSort)) {
            holder.mHotLayout.setVisibility(View.VISIBLE);
            holder.mTvViewCount.setText(NumberUtil.buildHundredMillion(list.get(position).getView_count()));
        } else if (StringUtil.isNotBlank(mSort) && StringUtil.equals("3", mSort)) {
            holder.mComicTitle.setVisibility(View.VISIBLE);
            holder.mComicTitle.setText(list.get(position).getLatest_comic_title());
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        private final GlideImageView mImageVertical;
        private final TextView mLikesContent;
        private final TextView mTvTitle;
        private final TextView mTvNickname;
        private final TextView mCommentsCount;
        private final RelativeLayout mRecLayout;
        private final RelativeLayout mHotLayout;
        private final TextView mComicTitle;
        private final TextView mTvViewCount;
        private final LinearLayout mLayoutItem;

        ContentViewHolder(View itemView) {
            super(itemView);
            mImageVertical = (GlideImageView) itemView.findViewById(R.id.image_vertical);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mTvNickname = (TextView) itemView.findViewById(R.id.tv_nickname);
            mLikesContent = (TextView) itemView.findViewById(R.id.tv_likes_content);
            mCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
            mRecLayout = (RelativeLayout) itemView.findViewById(R.id.rec_layout);
            mTvViewCount = (TextView) itemView.findViewById(R.id.tv_view_count);
            mHotLayout = (RelativeLayout) itemView.findViewById(R.id.hot_layout);
            mComicTitle = (TextView) itemView.findViewById(R.id.latest_comic_title);
            mLayoutItem = (LinearLayout) itemView.findViewById(R.id.layout_item);
        }

    }
    void setTag(String tag){
        mSort = tag;
        notifyDataSetChanged();
    }
}
