package com.example.lenovo.kuaikan.business.read.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadAdapter extends RecyclerView.Adapter<ReadAdapter.ReadViewHolder> {
    List<String> mImages;
    List<BeanRead.DataBean.ImageInfosBean> imageInfos;

    public ReadAdapter(List<String> mImages, Context context, List<BeanRead.DataBean.ImageInfosBean> imageInfos) {
        this.mImages = mImages;
        mContext = context;
        this.imageInfos = imageInfos;
    }

    private Context mContext;

    @Override
    public ReadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_item, parent, false);
        ReadViewHolder holder = new ReadViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReadViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.mImageView.getLayoutParams();
        if (imageInfos != null) {
            layoutParams.height = (int) (imageInfos.get(position).getHeight()/1.31);
            layoutParams.width = (int) (imageInfos.get(position).getWidth()/1.31);
            holder.mImageView.setLayoutParams(layoutParams);
        }
        holder.mImageView.setImage(mImages.get(position));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    class ReadViewHolder extends RecyclerView.ViewHolder {

        private final GlideImageView mImageView;

        public ReadViewHolder(View itemView) {
            super(itemView);
            mImageView = (GlideImageView) itemView.findViewById(R.id.glideimageview);
        }
    }
}
