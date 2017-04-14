package com.example.lenovo.kuaikan.community.comment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.community.comment.view.HotCommentFragment;
import com.example.lenovo.kuaikan.widget.TabAcionBar;

import butterknife.BindView;
import butterknife.OnClick;

public class CommentActivity extends BaseActivity {

    @BindView(R.id.tabactionbar)
    TabAcionBar mTabactionbar;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.comment_viewpager)
    ViewPager mCommentViewpager;
    @BindView(R.id.view_bottom)
    View mViewBottom;
    @BindView(R.id.ed_comment)
    EditText mEdComment;
    @BindView(R.id.tv_send)
    TextView mTvSend;

    @Override
    public int getlayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        final String feedId = getIntent().getStringExtra("feedId");
        mTabactionbar.setTabActionBarBackgroud(R.color.white);
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(this.getSupportFragmentManager()) {
                    @Override
                    public int getCount() {
                        return 2;
                    }

                    @Override
                    public Fragment getItem(int position) {
                        if (position == 0) {
                            return HotCommentFragment.newInstantac("time",feedId);
                        } else {
                            return HotCommentFragment.newInstantac("score",feedId);
                        }
                    }
                };
        mCommentViewpager.setAdapter(fragmentPagerAdapter);
        mCommentViewpager.setCurrentItem(0);
        // mTabActionBar和mViewpager的监听事件
        mTabactionbar.SetTabActionBarListener(this, mTabactionbar, mCommentViewpager);
    }

    @OnClick(R.id.image_back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
