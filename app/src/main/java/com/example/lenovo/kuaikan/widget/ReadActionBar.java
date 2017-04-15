package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadActionBar extends LinearLayout {
    @BindView(R.id.image_left)
    ImageView mImageLeft;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.image_right)
    ImageView mImageRight;
    @BindView(R.id.layout_read_action_bar)
    ConstraintLayout mLayoutReadActionBar;
    private String mTitle;
    private String mRightText;
    OnReadActionBarListener mOnReadActionBarListener;
    private int mRightImage;

    public void setOnReadActionBarListener(OnReadActionBarListener onReadActionBarListener) {
        mOnReadActionBarListener = onReadActionBarListener;
    }

    public ReadActionBar(Context context) {
        this(context, null);
    }

    public ReadActionBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReadActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ReadActionBar);
        mTitle = typedArray.getString(R.styleable.ReadActionBar_readTitle);
        mRightText = typedArray.getString(R.styleable.ReadActionBar_rightText);
        mRightImage = typedArray.getResourceId(R.styleable.ReadActionBar_rightImage, 0);
        typedArray.recycle();
        initView(context);

    }

    private void initView(Context context) {
        inflate(context, R.layout.read_action_bar, this);
        ButterKnife.bind(this);
        mTvTitle.setText(mTitle);
        mTvRight.setText(mRightText);
        mImageRight.setImageResource(mRightImage);
        if (mRightImage != 0) {
            mTvRight.setVisibility(GONE);
            mImageRight.setVisibility(VISIBLE);
        } else {
            mTvRight.setVisibility(VISIBLE);
            mImageRight.setVisibility(GONE);
        }
        mImageLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnReadActionBarListener != null) {
                    mOnReadActionBarListener.setLeftClickListener();
                }
            }
        });
        mTvRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnReadActionBarListener != null) {
                    mOnReadActionBarListener.setRightClickListener();
                }
            }
        });
    }

    public void setActionBarTvRight(String tvRight) {
        mTvTitle.setText(tvRight);
    }
    public void setReadActionBarBackgroud(int backgroud){
        mLayoutReadActionBar.setBackgroundResource(backgroud);
    }

    public void setActionBarTitle(String title) {
        mTvTitle.setText(title);
    }

    public interface OnReadActionBarListener {
        void setLeftClickListener();

        void setRightClickListener();
    }
}
