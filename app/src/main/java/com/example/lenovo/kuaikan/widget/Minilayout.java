package com.example.lenovo.kuaikan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class Minilayout extends RelativeLayout {

    private RelativeLayout mMinilayout;
    private ImageView mMiniLeftImge;
    private TextView mMiniName;
    private int mLeftImge;
    private String mName;
    private View mBottomView;
    private boolean mShowBottomView;
    private ImageView mMiniRightImge;
    private int mRightImge;

    public void setSetMiniClickListener(SetMiniClickListener setMiniClickListener) {
        mSetMiniClickListener = setMiniClickListener;
    }

    private SetMiniClickListener mSetMiniClickListener;

    public Minilayout(Context context) {
        this(context, null);
    }

    public Minilayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Minilayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Minilayout);
        mLeftImge = typedArray.getResourceId(R.styleable.Minilayout_miniLeftImge, 0);
        mRightImge = typedArray.getResourceId(R.styleable.Minilayout_miniRightImge, 0);
        mName = typedArray.getString(R.styleable.Minilayout_miniName);
        mShowBottomView = typedArray.getBoolean(R.styleable.Minilayout_showBottomView, true);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.minilayout, this);
        mMinilayout = (RelativeLayout) findViewById(R.id.minilayout);
        mMiniLeftImge = (ImageView) findViewById(R.id.img_left);
        mMiniRightImge = (ImageView) findViewById(R.id.img_right);
        mMiniName = (TextView) findViewById(R.id.tv_miniName);
        mBottomView = (View) findViewById(R.id.bottom_view);

        if (mRightImge != 0) {
            mMiniRightImge.setImageResource(mRightImge);
        } else {
            mMiniRightImge.setImageResource(R.mipmap.ic_listitem_next);
        }
        mMiniLeftImge.setImageResource(mLeftImge);
        mMiniName.setText(mName);
        if (mShowBottomView) {
            mBottomView.setVisibility(VISIBLE);
        } else {
            mBottomView.setVisibility(GONE);
        }
        mMinilayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSetMiniClickListener != null) {
                    mSetMiniClickListener.onMiniClickListener();
                }
            }
        });
    }

    public interface SetMiniClickListener {
        void onMiniClickListener();
    }

    public void setMiniLeftImge(int imge) {
        mMiniLeftImge.setImageResource(imge);
    }

    public void setMiniRightImge(int imge) {
        mMiniRightImge.setImageResource(imge);
    }

    public void setMiniName(String name) {
        mMiniName.setText(name);
    }

    public void showBottomView(Boolean show) {
        if (show) {
            mBottomView.setVisibility(VISIBLE);
        } else {
            mBottomView.setVisibility(GONE);
        }
    }
}
