package com.example.lenovo.kuaikan.widget.glide;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.ToastUtil;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class GlideImageView extends ImageView {

    private Context mCon;
    private int mDefaultImageResId;

    public GlideImageView(Context context) {
        this(context, null);
    }

    public GlideImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GlideImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCon = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GlideImageView);
        mDefaultImageResId = ta.getResourceId(R.styleable.GlideImageView_placeholderImage, 0);
        ta.recycle();
        if (mDefaultImageResId != 0){
            setImageResource(mDefaultImageResId);
        }

    }

    public void setImage(String url) {
        if (mDefaultImageResId != 0) {
            Glide.with(mCon)
                    .load(url)//目标URL
                    .placeholder(mDefaultImageResId) //占位图片
                    .error(mDefaultImageResId) //图片获取失败时默认显示的图片
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //缓存全尺寸图片，也缓存其他尺寸图片
                    .centerCrop()
                    .crossFade()
                    .into(this);
        }else{
            ToastUtil.showMessage("亲请设置默认图片n(*≧▽≦*)n");
        }

    }
    public void setDefaultImage(int backgroud){
        mDefaultImageResId = backgroud;

    }
    //        设置圆角图片
    public void setRounImage(String url) {
        if (mDefaultImageResId != 0) {
            Glide.with(mCon)
                    .load(url)
                    .asBitmap()
                    .placeholder(mDefaultImageResId)
                    .error(mDefaultImageResId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                    .into(new BitmapImageViewTarget(this) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(mCon.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            GlideImageView.this.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        }else{
            ToastUtil.showMessage("亲请设置默认图片n(*≧▽≦*)n");
        }

    }

}
