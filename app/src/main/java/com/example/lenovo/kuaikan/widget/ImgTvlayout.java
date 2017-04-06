package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

/**
 * Created by Zhanglibin on 2017/4/5.
 */

public class ImgTvlayout extends LinearLayout {

    private GlideImageView mImageView;
    private TextView mTextNmae;
    private TextView mTextInfo;
    private int mImge;
    private String mName;
    private String mInfo;
    private int mPlaceholderImage;

    public ImgTvlayout(Context context) {
        this(context,null);
    }

    public ImgTvlayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImgTvlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImgTvlayout);
        mImge = typedArray.getResourceId(R.styleable.ImgTvlayout_imge, 0);
        mName = typedArray.getString(R.styleable.ImgTvlayout_tvName);
        mInfo = typedArray.getString(R.styleable.ImgTvlayout_tvInfo);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.img_tv_layout,this);
        mImageView = (GlideImageView)findViewById(R.id.img);
        mTextNmae = (TextView)findViewById(R.id.tv_name);
        mTextInfo = (TextView)findViewById(R.id.tv_info);
        mTextNmae.setText(mName);
        mTextInfo.setText(mInfo);
        mImageView.setDefaultImage(mImge);
    }
    public void setTextInfo(String name){
        mTextNmae.setText(name);
    }
    public void setTextNmae(String info){
        mTextInfo.setText(info);
    }
    public void setDefaultImage(int placeholder){
        mImageView.setDefaultImage(placeholder);
    }
    public void setImage(String url){
        mImageView.setImage(url);
    }
    public void setScaleType(int type){
        if (type == 1) {
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }
}
