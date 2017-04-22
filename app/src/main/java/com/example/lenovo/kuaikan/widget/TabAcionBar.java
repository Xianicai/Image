package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.StringUtil;

/**
 * ZY:
 * Created by zhanglibin on 2017/3/28.
 */

public class TabAcionBar extends RelativeLayout {

    private ImageView imageTopLeft;
    private ImageView imageTopRight;
    private SwitchView switchView;
    private int acionBarLeftImge;
    private int acionBarRightImge;
    private String tabLeftText;
    private String tabRightText;
    private boolean tabLeftSelected;
    private boolean tabRightSelected;
    private RelativeLayout mLayout;

    public void setOnAcionBarClickListener(OnAcionBarClickListener mOnAcionBarClickListener) {
        this.mOnAcionBarClickListener = mOnAcionBarClickListener;
    }

    private OnAcionBarClickListener mOnAcionBarClickListener;

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
    }

    OnTabClickListener onTabClickListener;

    public TabAcionBar(Context context) {
        this(context, null);
    }

    public TabAcionBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabAcionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TabAcionBar);
        acionBarLeftImge = ta.getResourceId(R.styleable.TabAcionBar_imgeLeft, 0);
        acionBarRightImge = ta.getResourceId(R.styleable.TabAcionBar_imgeRight, 0);
        tabLeftText = ta.getString(R.styleable.TabAcionBar_tabLeftText);
        tabRightText = ta.getString(R.styleable.TabAcionBar_tabRightText);
        tabLeftSelected = ta.getBoolean(R.styleable.TabAcionBar_selectTabLeft, false);
        tabRightSelected = ta.getBoolean(R.styleable.TabAcionBar_selectTabRight, false);
        ta.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.tab_acionbar, this);
        mLayout = (RelativeLayout) findViewById(R.id.layout);
        imageTopLeft = (ImageView) findViewById(R.id.image_actionBar_left);
        imageTopRight = (ImageView) findViewById(R.id.image_actionBar_right);
        switchView = (SwitchView) findViewById(R.id.switchView);
        //左面图片的点击事件
        imageTopLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnAcionBarClickListener != null)
                    mOnAcionBarClickListener.onLeftImgAcionbarClick();
            }
        });
        //右面图片的点击事件
        imageTopRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnAcionBarClickListener != null)
                    mOnAcionBarClickListener.onRightImgAcionbarClick();
            }

        });
        switchView.setOnTabClickListener(new SwitchView.OnTabClickListener() {
            @Override
            public void onLeftClicked() {
                if (onTabClickListener != null) {
                    onTabClickListener.onLeftTabClicked();
                }
            }

            @Override
            public void onRightClicked() {
                if (onTabClickListener != null) {
                    onTabClickListener.onRightTabClicked();
                }
            }
        });
        //设置初始化属性
        if (acionBarLeftImge != 0) {
            imageTopLeft.setImageResource(acionBarLeftImge);
        }
        if (acionBarRightImge != 0) {
            imageTopRight.setImageResource(acionBarRightImge);
        }
        if (StringUtil.isNotEmpty(tabLeftText) && StringUtil.isNotEmpty(tabRightText)) {
            switchView.setTabText(tabLeftText, tabRightText);
        }
        switchView.setTabLeftSelected(context, tabLeftSelected);
        switchView.setTabRightSelected(context, tabRightSelected);
    }

    public interface OnAcionBarClickListener {
        void onLeftImgAcionbarClick();

        void onRightImgAcionbarClick();
    }

    public void setTabActionBarBackgroud(int barBackgroud) {
        mLayout.setBackgroundResource(barBackgroud);
    }

    public interface OnTabClickListener {
        void onLeftTabClicked();

        void onRightTabClicked();
    }

    public void setAcionBarLeftImg(int img) {
        imageTopLeft.setImageResource(img);
    }

    public void setAcionBarRightImg(int img) {
        imageTopRight.setImageResource(img);
    }

    public void setAcionBarImg(int leftImg, int rightImg) {
        imageTopLeft.setImageResource(leftImg);
        imageTopRight.setImageResource(rightImg);
    }

    public void setTabText(@NonNull String leftText, @NonNull String rightText) {
        if (StringUtil.isNotEmpty(leftText) && StringUtil.isNotEmpty(rightText)) {
            switchView.setTabText(leftText, rightText);
        }
    }

    public void setTabLeftSelected(Context context, boolean tabLeftSelected) {
        switchView.setTabLeftSelected(context, tabLeftSelected);
    }

    public void setTabRightSelected(Context context, boolean tabRightSelected) {
        switchView.setTabRightSelected(context, tabRightSelected);
    }

    public void setSwitchViewBackgroud(int leftBackgroud, int rightBackgroud) {
        switchView.setTabBackgroud(leftBackgroud, rightBackgroud);
    }

    // mTabActionBar和mViewpager的监听事件
    public void SetTabActionBarListener(final Context context, final TabAcionBar tabAcionBar, final ViewPager viewPager) {
        tabAcionBar.setOnTabClickListener(new TabAcionBar.OnTabClickListener() {
            @Override
            public void onLeftTabClicked() {
                viewPager.setCurrentItem(0);
            }

            @Override
            public void onRightTabClicked() {
                viewPager.setCurrentItem(1);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    tabAcionBar.setTabLeftSelected(context, true);
                } else if (position == 1) {
                    tabAcionBar.setTabRightSelected(context, true);
                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
