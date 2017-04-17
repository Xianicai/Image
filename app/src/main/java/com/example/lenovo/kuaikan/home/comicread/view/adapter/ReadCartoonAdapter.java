package com.example.lenovo.kuaikan.home.comicread.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/11.
 */

public class ReadCartoonAdapter extends RecyclerView.Adapter<ReadCartoonAdapter.ReadCartoonViewHolder> {
    List<String> mImages;

    public ReadCartoonAdapter(List<String> mImages, Context context) {
        this.mImages = mImages;
        mContext = context;
    }

    private Context mContext;

    @Override
    public ReadCartoonAdapter.ReadCartoonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.read_adapter_item_cartoon, viewGroup, false);
        ReadCartoonViewHolder holder = new ReadCartoonViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReadCartoonAdapter.ReadCartoonViewHolder readCartoonViewHolder, int i) {
        readCartoonViewHolder.mImageView.setImage(mImages.get(i));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    class ReadCartoonViewHolder extends RecyclerView.ViewHolder {

        private final GlideImageView mImageView;

        public ReadCartoonViewHolder(View itemView) {
            super(itemView);
            mImageView = (GlideImageView) itemView.findViewById(R.id.glideimageview);
        }
    }


}
