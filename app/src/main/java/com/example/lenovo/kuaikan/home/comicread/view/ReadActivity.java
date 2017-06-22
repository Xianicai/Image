package com.example.lenovo.kuaikan.home.comicread.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.community.comment.view.CommentActivity;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.home.comicread.presenter.ReadPresenterImpl;
import com.example.lenovo.kuaikan.home.comicread.view.adapter.ReadAdapter;
import com.example.lenovo.kuaikan.widget.ReadActionBar;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class ReadActivity extends BaseActivity implements IReadView {


    @BindView(R.id.readActionBar)
    ReadActionBar mReadActionBar;
    @BindView(R.id.read_recyclerview)
    RecyclerView mReadRecyclerview;
    @BindView(R.id.image_comment)
    ImageView mImageComment;
    @BindView(R.id.image_share)
    ImageView mImageShare;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.layout_comment)
    ConstraintLayout mLayoutComment;
    @BindView(R.id.progressBar)
    CircleProgressBar mProgressBar;
    @BindView(R.id.ed_comment)
    EditText mEdComment;
    @BindView(R.id.danmaku_view)
    DanmakuView mDanmakuView;
    private ReadPresenterImpl mReadPresenter;
    private List<String> mImages;
    private ReadAdapter mReadAdapter;
    private String mComicsId;
    private List<BeanRead.DataBean.ImageInfosBean> mImageInfos;
    private String comicId;
    private List<BeanComments.DataBean.CommentsBean> mComments;
    //弹幕
    private boolean showDanmaku;

    private DanmakuContext danmakuContext;

    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };

    @Override
    public int getlayoutId() {
        return R.layout.activity_read;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mComicsId = getIntent().getStringExtra("comicsId");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //漫画的Recyclerview
        mImages = new ArrayList<>();
        mImageInfos = new ArrayList<>();
        mReadAdapter = new ReadAdapter(mImages, this, mImageInfos, mComicsId);
        mReadRecyclerview.setAdapter(mReadAdapter);
        mReadPresenter = new ReadPresenterImpl();
        mReadPresenter.bindView(this);
        mReadPresenter.getSeverData(mComicsId);
        mReadPresenter.getCommentData(mComicsId);
        mReadRecyclerview.setLayoutManager(linearLayoutManager);
        mReadActionBar.setOnReadActionBarListener(new ReadActionBar.OnReadActionBarListener() {
            @Override
            public void setLeftClickListener() {
                onBackPressed();
            }

            @Override
            public void setRightClickListener() {

            }
        });

        //弹幕
        mDanmakuView.enableDanmakuDrawingCache(true);
        mDanmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                showDanmaku = true;
                mDanmakuView.start();
                generateSomeDanmaku();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
        danmakuContext = DanmakuContext.create();
        mDanmakuView.prepare(parser, danmakuContext);
    }


    @Override
    public void showMsg(String str) {

    }

    @Override
    public void showLoadingDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void cancelLoadingDialog() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void getServerDataSuccess(BeanRead data) {
        if (data != null) {
            comicId = data.getData().getPrevious_comic_id() + "";
            mTvCommentNum.setText(data.getData().getComments_count() + "");
            mReadActionBar.setActionBarTitle(data.getData().getTitle());
            mImageInfos.addAll(data.getData().getImage_infos());
            mImages.addAll(data.getData().getImages());
            mReadAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getServerDataFail() {

    }

    @Override
    public void getCommentDataSuccess(BeanComments beanComments) {
        mReadAdapter.setComments(beanComments.getData().getComments());
        mReadAdapter.notifyDataSetChanged();
        mReadAdapter.mCommentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static void toRead(Context context, String comicsId) {
        Intent intent = new Intent(context, ReadActivity.class);
        intent.putExtra("comicsId", comicsId);
        context.startActivity(intent);
    }

    @OnClick({R.id.image_comment, R.id.image_share, R.id.layout_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_comment:
                CommentActivity.toComment(this, comicId, 1);
                break;
            case R.id.image_share:
                break;
            case R.id.layout_comment:
                break;
        }
    }


    @OnClick(R.id.ed_comment)
    public void onViewClicked() {
    }


    /**
     * 向弹幕View中添加一条弹幕
     * @param content
     *          弹幕的具体内容
     * @param  withBorder
     *          弹幕是否有边框
     */
    private void addDanmaku(String content, boolean withBorder) {
        BaseDanmaku danmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        danmaku.text = content;
        danmaku.padding = 5;
        danmaku.textSize = sp2px(20);
        danmaku.textColor = Color.WHITE;
        danmaku.setTime(mDanmakuView.getCurrentTime());
        if (withBorder) {
            danmaku.borderColor = Color.GREEN;
        }
        mDanmakuView.addDanmaku(danmaku);
    }

    /**
     * 随机生成一些弹幕内容以供测试
     */
    private void generateSomeDanmaku() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(showDanmaku) {
                    int time = new Random().nextInt(300);
                    String content = "" + time + time;
                    addDanmaku(content, false);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * sp转px的方法。
     */
    public int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
