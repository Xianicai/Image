package com.example.lenovo.kuaikan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.image_left)
    ImageView mImageLeft;
    @BindView(R.id.image_top)
    ImageView mImageTop;
    @BindView(R.id.ed_phone)
    EditText mEdPhone;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.ed_password)
    EditText mEdPassword;
    @BindView(R.id.tv_tips)
    TextView mTvTips;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.img_QQ)
    ImageView mImgQQ;
    @BindView(R.id.img_WB)
    ImageView mImgWB;
    @BindView(R.id.img_WX)
    ImageView mImgWX;
    @BindView(R.id.image_phone)
    ImageView mImagePhone;
    @BindView(R.id.image_password)
    ImageView mImagePassword;

    @Override
    public int getlayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mEdPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    // 此处为得到焦点时的处理内容
                    mImagePhone.setImageResource(R.mipmap.ic_login_phone_highlighted);
                } else {
                    // 此处为失去焦点时的处理内容
                    mImagePhone.setImageResource(R.mipmap.ic_login_phone_normal);
                }
            }
        });
        mEdPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    // 此处为得到焦点时的处理内容
                    mImageTop.setImageResource(R.mipmap.ic_login_invisible);
                    mImagePassword.setImageResource(R.mipmap.ic_login_pwd_highlighted);
                } else {
                    // 此处为失去焦点时的处理内容
                    mImageTop.setImageResource(R.mipmap.ic_login_visible);
                    mImagePassword.setImageResource(R.mipmap.ic_login_pwd_normal);
                }
            }
        });
    }

    @OnClick({R.id.image_left, R.id.image_top, R.id.ed_phone, R.id.ed_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left:
                onBackPressed();
                break;
            case R.id.image_top:
                break;
            case R.id.ed_phone:
                break;
            case R.id.ed_password:

                break;
        }
    }

    public static void toLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
