package com.example.lenovo.kuaikan.home.comicread.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> mImages;
    List<BeanRead.DataBean.ImageInfosBean> imageInfos;
    private Context mContext;


    public ReadAdapter(List<String> mImages, Context context, List<BeanRead.DataBean.ImageInfosBean> imageInfos) {
        this.mImages = mImages;
        mContext = context;
        this.imageInfos = imageInfos;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mImages.size()) {
           return -1 ;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == -1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_item_centre, parent, false);
            ReadButtomVH holder = new ReadButtomVH(view);
            return holder;
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_item, parent, false);
        ReadViewHolder holder = new ReadViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position != mImages.size()) {
            ViewGroup.LayoutParams layoutParams = ((ReadViewHolder)holder).mImageView.getLayoutParams();
            if (imageInfos != null && imageInfos.size()!=0) {
//            layoutParams.height =  DensityUtil.sp2px(mContext,imageInfos.get(position).getHeight());
//            layoutParams.width =  DensityUtil.sp2px(mContext,imageInfos.get(position).getWidth());
//            layoutParams.height =  imageInfos.get(position).getHeight();
                layoutParams.width =  imageInfos.get(position).getWidth();
                layoutParams.height = (int) (imageInfos.get(position).getHeight()/1.2);
                layoutParams.width = (int) (imageInfos.get(position).getWidth()/1.2);
                ((ReadViewHolder)holder).mImageView.setLayoutParams(layoutParams);
            }
            ((ReadViewHolder)holder).mImageView.setImage(mImages.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return mImages.size()+1;
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
}
