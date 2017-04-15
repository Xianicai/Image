package com.example.lenovo.kuaikan.home.hot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.basemvp.BaseReq;
import com.example.lenovo.kuaikan.community.comment.view.CommentActivity;
import com.example.lenovo.kuaikan.home.comicdetails.view.ComicDetailActivity;
import com.example.lenovo.kuaikan.home.hot.bean.BeanHomeHot;
import com.example.lenovo.kuaikan.utils.NumberUtil;
import com.example.lenovo.kuaikan.utils.ToastUtil;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.HotViewHolder> {


    private List<BeanHomeHot.DataBean.ComicsBean> mComicsBeen;//要显示的数据
    private Context context;//创建视图时需要
    private String comicsId;

    public void setHotAdapterEvent(HotAdapterEvent hotAdapterEvent) {
        mHotAdapterEvent = hotAdapterEvent;
    }

    HotAdapterEvent mHotAdapterEvent;

    //定义接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public HotAdapter(List<BeanHomeHot.DataBean.ComicsBean> mComicsBeen, Context context) {
        this.mComicsBeen = mComicsBeen;
        this.context = context;
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //创建视图
        View view = LayoutInflater.from(context).inflate(R.layout.hot_adapter_item, viewGroup, false);
        //实例化MainViewHolder---- 传View过去
        HotViewHolder holder = new HotViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HotViewHolder hotViewHolder, final int i) {
        //获取要填充的值
        String labelText = mComicsBeen.get(i).getLabel_text();
        String coverImageUrl = mComicsBeen.get(i).getCover_image_url();
        String title = mComicsBeen.get(i).getTopic().getTitle();
        String comicsTitle = mComicsBeen.get(i).getTitle();
        int likesCount = mComicsBeen.get(i).getLikes_count();
        int commentsCount = mComicsBeen.get(i).getComments_count();
        String labelColor = mComicsBeen.get(i).getLabel_color();
        //控件中设置值
        hotViewHolder.mTvLabe.setText(labelText);
        hotViewHolder.imgeCover.setImage(coverImageUrl);
        hotViewHolder.mTitle.setText(title);
        hotViewHolder.mComicsTitle.setText(comicsTitle);
        hotViewHolder.mLikesCount.setText(NumberUtil.buildTenThousand(likesCount));
        hotViewHolder.mCommentsCount.setText(NumberUtil.buildTenThousand(commentsCount));
        GradientDrawable myGrad = (GradientDrawable) hotViewHolder.mTvLabe.getBackground();
        myGrad.setColor(Color.parseColor(mComicsBeen.get(i).getLabel_color()));
        //监听事件
        hotViewHolder.imgeCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHotAdapterEvent != null) {
                    comicsId = mComicsBeen.get(i).getId() + "";
                    mHotAdapterEvent.event();
                }
            }
        });
        hotViewHolder.mCommentsCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra(CommentActivity.COMMENT_TYPE, 1);
                intent.putExtra("feedId", mComicsBeen.get(i).getId() + "");
                context.startActivity(intent);
            }
        });
        hotViewHolder.mImgCommentNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra(CommentActivity.COMMENT_TYPE, 1);
                intent.putExtra("feedId", mComicsBeen.get(i).getId() + "");
                context.startActivity(intent);
            }
        });
        hotViewHolder.mLayoutTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ComicDetailActivity.class);
                context.startActivity(intent);
            }
        });
        hotViewHolder.mImgLikeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BaseReq req = new BaseReq();
                String url = Urls.parse(Urls.COMICSID_LIKE, mComicsBeen.get(i).getId() + "");
                NetAsynTask.connectByPost(url, null, req, new NetAsynTask.CallBack() {
                    @Override
                    public void onGetSucc() {
                        if (req.code == 200) {
                            ToastUtil.showMessage("点赞成功n(*≧▽≦*)n");
                        }
                    }

                    @Override
                    public void onGetFinished() {
                    }

                    @Override
                    public void onGetFaild() {

                    }

                    @Override
                    public void onGetError() {

                    }
                });
            }
        });
    }


    /**
     * 获取item的总个数
     */
    @Override
    public int getItemCount() {
        return mComicsBeen.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * 初始化控件
     */
    public class HotViewHolder extends RecyclerView.ViewHolder {
        TextView mTvLabe;
        TextView tvShow;
        LinearLayout hotFragmentItem;
        GlideImageView imgeCover;
        private final TextView mTitle;
        private final TextView mComicsTitle;
        private final TextView mLikesCount;
        private final TextView mCommentsCount;
        private final ImageView mImgLikeNumber;
        private final ImageView mImgCommentNumber;
        private final RelativeLayout mLayoutTop;


        public HotViewHolder(View itemView) {
            super(itemView);
            //初始化控件
            hotFragmentItem = (LinearLayout) itemView.findViewById(R.id.hot_fragment_item);
            mTvLabe = (TextView) itemView.findViewById(R.id.tv_labe);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            imgeCover = (GlideImageView) itemView.findViewById(R.id.imge_cover);
            mComicsTitle = (TextView) itemView.findViewById(R.id.tv_comicsTitle);
            mLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_count);
            mCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
            mImgLikeNumber = (ImageView) itemView.findViewById(R.id.img_likeNumber);
            mImgCommentNumber = (ImageView) itemView.findViewById(R.id.img_commentNumber);
            mLayoutTop = (RelativeLayout) itemView.findViewById(R.id.layout_top);


        }
    }

    public interface HotAdapterEvent {
        void event();
    }

    public String getComicsId() {
        return comicsId;
    }
}
