package com.example.lenovo.kuaikan.business.read.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.business.read.data.BeanComments;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/11.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    List<BeanComments.DataBean.CommentsBean> mComments;
    Context mContext;

    public CommentAdapter(List<BeanComments.DataBean.CommentsBean> mComments, Context context) {
        this.mComments = mComments;
        mContext = context;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_read_comment_item, parent, false);
        CommentViewHolder viewHolder = new CommentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.tvUseName.setText(mComments.get(position).getUser().getNickname());

    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvUseName;

        public CommentViewHolder(View itemView) {
            super(itemView);
            tvUseName = (TextView) itemView.findViewById(R.id.tv_user_name);
        }
    }
}
