package com.example.lenovo.kuaikan.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EgActivity extends BaseActivity {


    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.imge_cover)
    GlideImageView mImgeCover;
    @BindView(R.id.tv_label)
    TextView mTvLabel;
    @BindView(R.id.image_right)
    ImageView mImageRight;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
//    @BindView(R.id.tv_title)
//    TextView mTvTitle;

    @Override
    public int getlayoutId() {
        return R.layout.ed_activity;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(new ContentAdapter());
        mCollapsingToolbarLayout.setTitle("有梦想的人不睡觉");
//        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(int)
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
//                    mTvTitle.setText("");
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    mTvTitle.setText("有梦想的人不睡觉");
                } else {
//                    mTvTitle.setText("");
                }
            }
        });
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    private class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {
        @Override
        public ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ContentHolder(LayoutInflater.from(EgActivity.this).inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(ContentHolder holder, int position) {
            holder.itemTv.setText("item");
        }

        @Override
        public int getItemCount() {
            return 35;
        }

        class ContentHolder extends RecyclerView.ViewHolder {

            private TextView itemTv;

            public ContentHolder(View itemView) {
                super(itemView);
                itemTv = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}


