package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class AcrossImageTv extends LinearLayout {
    @BindView(R.id.image)
    GlideImageView mImage;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_label)
    TextView mTvLabel;
    @BindView(R.id.tv_frome)
    TextView mTvFrome;
    @BindView(R.id.layout_labe)
    LinearLayout mLayoutLabe;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_style)
    TextView mTvStyle;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.layout_comment)
    RelativeLayout mLayoutComment;
    private int mAddLayout;

    public AcrossImageTv(Context context) {
        this(context, null);
    }

    public AcrossImageTv(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AcrossImageTv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AcrossImageTv);
        mAddLayout = typedArray.getResourceId(R.styleable.AcrossImageTv_addLayout, 1);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.across_imagetv, this);
        ButterKnife.bind(this);
        if (mAddLayout == 1) {
            mLayoutLabe.setVisibility(VISIBLE);
            mLayoutComment.setVisibility(GONE);
        } else {
            mLayoutComment.setVisibility(VISIBLE);
            mLayoutLabe.setVisibility(GONE);
        }

    }


    public void setImage(String url) {
        mImage.setImage(url);
    }
    public void setDefaultImage(int defaultImage) {
        mImage.setDefaultImage(defaultImage);
    }
    public void addLayout(int type) {
        if (type == 1) {
            mLayoutLabe.setVisibility(VISIBLE);
            mLayoutComment.setVisibility(GONE);
        } else {
            mLayoutComment.setVisibility(VISIBLE);
            mLayoutLabe.setVisibility(GONE);
        }
    }
    public void setLayoutLabeName(String name) {
        mTvName.setText(name);
    }

    public void setLayoutLabeLable(String lable) {
        mTvLabel.setText(lable);
    }

    public void setLayoutLabeFrome(String frome) {
        mTvFrome.setText(frome);
    }

    public void setLayoutCommentTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setLayoutCommentStyle(String style) {
        mTvStyle.setText(style);
    }

    public void setLayoutCommentCommentNum(String commentNum) {
        mTvCommentNum.setText(commentNum);
    }

}
