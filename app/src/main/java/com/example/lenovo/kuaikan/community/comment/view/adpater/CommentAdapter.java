package com.example.lenovo.kuaikan.community.comment.view.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.kuaikan.community.comment.model.data.CommentBean;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/13.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommenterViewHolder> {
    List<CommentBean.DataBean.CommentsBean> mComments;

    public CommentAdapter(List<CommentBean.DataBean.CommentsBean> comments, Context context) {
        mComments = comments;
        mContext = context;
    }

    Context mContext;
    @Override
    public CommenterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(CommenterViewHolder commenterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class CommenterViewHolder extends RecyclerView.ViewHolder{

      public CommenterViewHolder(View itemView) {
          super(itemView);
      }
  }
}
