package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.StringUtil;

/**
 * Created by Zhanglibin on 2017/3/28.
 */

public class SwitchView extends LinearLayout {
    OnTabClickListener mOnTabClickListener;
    private TextView mTvLeft;
    private TextView mTvRight;
    private String mLeftText;
    private String mRightText;
    private boolean selectedLeft;
    private boolean selectedRight;

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        mOnTabClickListener = onTabClickListener;
    }

    public SwitchView(Context context) {
        this(context, null);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SwitchView);
        mLeftText = ta.getString(R.styleable.SwitchView_tvLeft);
        mRightText = ta.getString(R.styleable.SwitchView_tvRight);
        selectedLeft = ta.getBoolean(R.styleable.SwitchView_selectLeft, false);
        selectedRight = ta.getBoolean(R.styleable.SwitchView_selectRight, false);
        ta.recycle();
        init(context);
    }

    private void init(final Context context) {

        //1:获取自定义属性，提供一些默认值
        //2：初始化布局

        inflate(context, R.layout.switch_view, this);

        //3；找控件
        mTvLeft = (TextView) findViewById(R.id.tv_top_left);
        mTvRight = (TextView) findViewById(R.id.tv_top_right);
        mTvLeft.setText(mLeftText);
        mTvRight.setText(mRightText);
        //4:设置点击事件
        mTvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedRight) {
                    selectedLeft = !selectedLeft;
                    selectedRight = !selectedRight;
                    checkTabSelected(context);
                    if (mOnTabClickListener != null)
                        mOnTabClickListener.onLeftClicked();
                }
            }
        });
        mTvRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedLeft) {
                    selectedLeft = !selectedLeft;
                    selectedRight = !selectedRight;
                    checkTabSelected(context);
                    if (mOnTabClickListener != null)
                        mOnTabClickListener.onRightClicked();
                }
            }
        });

        checkTabSelected(context);
        //6:其他：设置字体大小，颜色，背景颜色。。。

    }


    //5:设置接口，暴露点击事件，或者 配置一些信息
    public interface OnTabClickListener {
        void onLeftClicked();

        void onRightClicked();
    }

    public void setTabText(@NonNull String left, @NonNull String right) {
        if (StringUtil.isNotEmpty(left)) {
            mTvLeft.setText(left);
        }
        if (StringUtil.isNotEmpty(right)) {
            mTvRight.setText(right);
        }
    }

    public void setTabLeftSelected(Context context, Boolean selectedLeft) {
        if (selectedLeft) {
            selectedRight = false;
        }
        this.selectedLeft = selectedLeft;
        checkTabSelected(context);
    }

    public void setTabRightSelected(Context context, Boolean selectedRight) {
        if (selectedRight) {
            selectedLeft = false;
        }
        this.selectedRight = selectedRight;
        checkTabSelected(context);
    }

    //设置tab选中的样式
    private void checkTabSelected(Context context) {
        if (selectedLeft) {
            mTvLeft.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_selector_selected));
            mTvLeft.setTextColor(ContextCompat.getColor(context, R.color.brown));
            mTvRight.setBackground(null);
            mTvRight.setTextColor(ContextCompat.getColor(context, R.color.yellow));
        } else if (selectedRight) {
            mTvRight.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_selector_selected));
            mTvRight.setTextColor(ContextCompat.getColor(context, R.color.brown));
            mTvLeft.setBackground(null);
            mTvLeft.setTextColor(ContextCompat.getColor(context, R.color.yellow));

        }
    }
}
