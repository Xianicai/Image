package com.example.lenovo.kuaikan.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.widget.ImgTvlayout;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/5.
 */

public class RecommAdapter extends RecyclerView.Adapter<RecommAdapter.RecommViewHolder> {
    private Context mContext;
    private List<BeanRecomm.DataBean.InfosBean> mInfosBeen;

    public RecommAdapter(Context context, List<BeanRecomm.DataBean.InfosBean> mInfosBeen) {
        mContext = context;
        this.mInfosBeen = mInfosBeen;
    }

    @Override
    public RecommViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecommViewHolder holder = null;
        if (viewType == R.layout.recomm_fragment_item_top) {
            view = LayoutInflater.from(mContext).inflate(viewType, parent, false);
            holder = new RecommViewHolder(view);
        } else if (viewType == R.layout.recomm_fragment_item_six) {
            view = LayoutInflater.from(mContext).inflate(viewType, parent, false);
            holder = new RecommViewHolder(view);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecommViewHolder holder, int position) {
        //        第一个item
        if (position == 0) {
            holder.mTvTopTitle.setText(mInfosBeen.get(position).getTitle());
            //上左
            setTopItem(holder.mTopTopleft, 0);
            //上右
            setTopItem(holder.mTopTopright, 1);
            //下左
            setTopItem(holder.mTopButtomleft, 2);
            //下左
            setTopItem(holder.mTopButtomright, 3);
        } else if (position == 0) {
            //        第二个item
            holder.mTvTitle.setText(mInfosBeen.get(position).getTitle());
            //上左
            setSixItem(holder.mLayoutTopLeft, position, 0);
            //上中
            setSixItem(holder.mLayoutTopCentre, position, 1);
            //上右
            setSixItem(holder.mLayoutTopRight, position, 2);
            //下左
            setSixItem(holder.mLayoutButtomLeft, position, 3);
            //下中
            setSixItem(holder.mLayoutButtomCentre, position, 4);
            //下右
            setSixItem(holder.mLayoutButtomRight, position, 5);

        }


    }

    private void setSixItem(ImgTvlayout sixLayout, int position, int i) {
        BeanRecomm.DataBean.InfosBean.TopicsBean TopLeftBean = mInfosBeen.get(position).getTopics().get(i);
        sixLayout.setImge(TopLeftBean.getPic());
        sixLayout.setTextNmae((TopLeftBean.getTitle()));
        sixLayout.setTextInfo(TopLeftBean.getCategory().get(0) + " " + TopLeftBean.getCategory().get(1));
    }

    private void setTopItem(ImgTvlayout imgTvlayout, int i) {

        imgTvlayout.setImge(mInfosBeen.get(0).getTopics().get(i).getPic());
        imgTvlayout.setTextNmae((mInfosBeen.get(0).getTopics().get(i).getTitle()));
        imgTvlayout.setTextInfo((mInfosBeen.get(0).getTopics().get(i).getDescription()));
    }

    @Override
    public int getItemCount() {
        return mInfosBeen.size();
    }

    @Override
    public int getItemViewType(int position) {
        int mView = 0;
        switch (position) {
            case 0:
                mView = R.layout.recomm_fragment_item_top;
                break;
            case 1:
                mView = R.layout.recomm_fragment_item_six;
                break;
        }
        return mView;
    }

    class RecommViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvTopTitle;
        private final ImgTvlayout mTopTopleft;
        private final ImgTvlayout mTopTopright;
        private final ImgTvlayout mTopButtomleft;
        private final ImgTvlayout mTopButtomright;
        private final TextView mTvTitle;
        private final ImgTvlayout mLayoutTopLeft;
        private final ImgTvlayout mLayoutTopCentre;
        private final ImgTvlayout mLayoutTopRight;
        private final ImgTvlayout mLayoutButtomLeft;
        private final ImgTvlayout mLayoutButtomCentre;
        private final ImgTvlayout mLayoutButtomRight;

        public RecommViewHolder(View itemView) {
            super(itemView);
            //第一个item
            mTvTopTitle = (TextView) itemView.findViewById(R.id.tv_top_title);
            mTopTopleft = (ImgTvlayout) itemView.findViewById(R.id.top_top_left);
            mTopTopright = (ImgTvlayout) itemView.findViewById(R.id.top_top_right);
            mTopButtomleft = (ImgTvlayout) itemView.findViewById(R.id.top_buttom_left);
            mTopButtomright = (ImgTvlayout) itemView.findViewById(R.id.top_buttom_right);
            //第一个item
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mLayoutTopLeft = (ImgTvlayout) itemView.findViewById(R.id.layout_top_left);
            mLayoutTopCentre = (ImgTvlayout) itemView.findViewById(R.id.layout_top_centre);
            mLayoutTopRight = (ImgTvlayout) itemView.findViewById(R.id.layout_top_right);
            mLayoutButtomLeft = (ImgTvlayout) itemView.findViewById(R.id.layout_buttom_left);
            mLayoutButtomCentre = (ImgTvlayout) itemView.findViewById(R.id.layout_buttom_centre);
            mLayoutButtomRight = (ImgTvlayout) itemView.findViewById(R.id.layout_buttom_right);

        }
    }
}
