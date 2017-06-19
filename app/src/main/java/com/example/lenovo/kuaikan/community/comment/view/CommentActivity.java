package com.example.lenovo.kuaikan.community.comment.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.widget.TabAcionBar;

import butterknife.BindView;
import butterknife.OnClick;

public class CommentActivity extends BaseActivity  {

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
    /**
     * 评论的TYPE  1：漫画评论，2;动态评论
     */
    public static String COMMENT_TYPE;

    @Override
    public int getlayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        final String feedId = getIntent().getStringExtra("feedId");
        final int commentType = getIntent().getIntExtra(COMMENT_TYPE, 0);
//        mTabactionbar.setSwitchViewBackgroud(R.color.commentleft,R.color.commentright);
        mTabactionbar.setTabActionBarBackgroud(R.color.white);
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(this.getSupportFragmentManager()) {
                    @Override
                    public int getCount() {
                        return 2;
                    }

                    @Override
                    public Fragment getItem(int position) {
                        if (commentType == 1) {
                            if (position == 0) {
                                return HotCommentFragment.newInstantac("", feedId, commentType);
                            } else {
                                return HotCommentFragment.newInstantac("score", feedId, commentType);
                            }
                        } else {
                            if (position == 0) {
                                return HotCommentFragment.newInstantac("time", feedId, commentType);
                            } else {
                                return HotCommentFragment.newInstantac("score", feedId, commentType);
                            }
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
    public static void toComment(Context context,String feedId,int type){
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra(CommentActivity.COMMENT_TYPE, type);
        intent.putExtra("feedId", feedId);
        context.startActivity(intent);
    }
}
