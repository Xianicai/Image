package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

/**
 * Created by Zhanglibin on 2017/4/1.
 */

public class SquareImageView extends GlideImageView {
    public SquareImageView(Context context) {
        this(context,null);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    重写onMeasure方法 传入widthMeasureSpec宽作为heightMeasureSpec高(图片成正方形)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public void setImage(String url) {
        super.setImage(url);
    }
}
