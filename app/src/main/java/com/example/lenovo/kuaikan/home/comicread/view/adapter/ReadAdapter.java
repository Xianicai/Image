package com.example.lenovo.kuaikan.home.comicread.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.home.comicread.model.data.ReqComments;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;
import com.example.lenovo.kuaikan.widget.XRecyclerview;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> mImages;
    List<BeanRead.DataBean.ImageInfosBean> imageInfos;
    private Context mContext;
    private String mComicsId;
    private CommentAdapter mCommentAdapter;
    List<BeanComments.DataBean.CommentsBean> mComments;
    private XRecyclerview mCommentRecyclerview;

    public ReadAdapter(List<String> mImages, Context context, List<BeanRead.DataBean.ImageInfosBean> imageInfos,
                       String mComicsId) {
        this.mImages = mImages;
        mContext = context;
        this.imageInfos = imageInfos;
        this.mComicsId = mComicsId;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mImages.size()) {
            return -1;
        } else if (position == mImages.size() + 1) {
            return -2;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == -1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_item_centre, parent, false);
            ReadButtomVH holder = new ReadButtomVH(view);
            return holder;
        } else if (viewType == -2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.read_comment_item, parent, false);
            ReadCommentVH holder = new ReadCommentVH(view);
            return holder;
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_item, parent, false);
        ReadViewHolder holder = new ReadViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReadViewHolder) {
            ViewGroup.LayoutParams layoutParams = ((ReadViewHolder) holder).mImageView.getLayoutParams();
            if (imageInfos != null && imageInfos.size() != 0) {
                layoutParams.width = imageInfos.get(position).getWidth();
                layoutParams.height = (int) (imageInfos.get(position).getHeight() / 1.2);
                layoutParams.width = (int) (imageInfos.get(position).getWidth() / 1.2);
                ((ReadViewHolder) holder).mImageView.setLayoutParams(layoutParams);
            }
            ((ReadViewHolder) holder).mImageView.setImage(mImages.get(position));
        } else if (holder instanceof ReadButtomVH) {
            return;
        } else if (holder instanceof ReadCommentVH) {
            mCommentRecyclerview = ((ReadCommentVH) holder).mCommentRecyclerview;
            LinearLayoutManager mCommentlayoutManager = new LinearLayoutManager(mContext,
                    LinearLayoutManager.VERTICAL, false) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            mCommentRecyclerview.setLayoutManager(mCommentlayoutManager);
            mComments = new ArrayList<>();
            mCommentAdapter = new CommentAdapter(mComments, mContext);
            mCommentRecyclerview.setAdapter(mCommentAdapter);
            getData();
//            评论列表的滑动监听
            RecyclerView reclerView = mCommentRecyclerview.getReclerView();
            reclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                    layoutParams.height = (int) (mCommentAdapter.getItemAllHight() / 2);
                    recyclerView.setLayoutParams(layoutParams);
                    notifyDataSetChanged();
                    mCommentAdapter.notifyDataSetChanged();
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
//                mLayoutComment.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    private void getData() {
        final ReqComments req = new ReqComments();
        String url = Urls.parse(Urls.COMICSID_COMMENTS, mComicsId);
        NetAsynTask.connectByGet(url, null, req, new NetAsynTask.CallBack() {

            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    //初始化一个bean用保存本次请求下来的数据
                    BeanComments beanComments = req.getT();
                    mComments.addAll(beanComments.getData().getComments());
                    mCommentAdapter.notifyDataSetChanged();
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

    @Override
    public int getItemCount() {
        return mImages.size() + 2;
    }

    class ReadViewHolder extends RecyclerView.ViewHolder {

        private final GlideImageView mImageView;

        public ReadViewHolder(View itemView) {
            super(itemView);
            mImageView = (GlideImageView) itemView.findViewById(R.id.glideimageview);
        }
    }

    class ReadButtomVH extends RecyclerView.ViewHolder {
        public ReadButtomVH(View itemView) {
            super(itemView);
        }
    }

    class ReadCommentVH extends RecyclerView.ViewHolder {

        private final XRecyclerview mCommentRecyclerview;

        public ReadCommentVH(View itemView) {
            super(itemView);
            mCommentRecyclerview = (XRecyclerview) itemView.findViewById(R.id.comment_recyclerview);
        }
    }
}
