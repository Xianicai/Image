package com.example.lenovo.kuaikan.home.comicdetails.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicdetails.presenter.ComicDetailPresenter;
import com.example.lenovo.kuaikan.home.comicread.view.ReadActivity;
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import butterknife.BindView;
import butterknife.OnClick;

public class ComicDetailActivity extends BaseActivity implements ImpComicDatailView {
    @BindView(R.id.imge_cover)
    GlideImageView mImgeCover;
    @BindView(R.id.tv_comic_name)
    TextView mTvComicName;
    @BindView(R.id.tv_label)
    TextView mTvLabel;
    @BindView(R.id.comic_tablayout)
    TabLayout mComicTablayout;
    @BindView(R.id.comic_viewpager)
    ViewPager mComicViewpager;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.tv_comic_title)
    TextView mTvComicTitle;
    @BindView(R.id.tv_read)
    TextView mTvRead;
    @BindView(R.id.image_back)
    ImageView mImageBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.image_right)
    ImageView mImageRight;
    @BindView(R.id.view_tab)
    View mViewTab;
    @BindView(R.id.progressBar)
    CircleProgressBar mProgressBar;
    private String[] mTitles = new String[]{"详情", "选集"};
    private ComicDetailFragment mComicDetailFragment;
    private ComicsListFragment mComicsListFragment;
    private String mComicId;

    @Override
    public int getlayoutId() {
        return R.layout.activity_comic_detail;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mComicId = getIntent().getStringExtra("comicId");
        //给TabLayout添加标签
        for (int i = 0; i < mTitles.length; i++) {
            mComicTablayout.addTab(mComicTablayout.newTab().setText(mTitles[i]));
        }
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getSupportFragmentManager()) {


                    @Override
                    public Fragment getItem(int position) {
                        Fragment fragment = null;
                        switch (position) {
                            case 0:
                                mComicDetailFragment = new ComicDetailFragment();
                                fragment = mComicDetailFragment;
                                break;
                            case 1:
                                mComicsListFragment = new ComicsListFragment();
                                fragment = mComicsListFragment;
                                break;

                        }

                        return fragment;
                    }

                    @Override
                    public int getCount() {
                        return mTitles.length;
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return mTitles[position];
                    }

                };
        mComicViewpager.setAdapter(fragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mComicTablayout.setupWithViewPager(mComicViewpager);
        mComicViewpager.setCurrentItem(1);
        ComicDetailPresenter presenter = new ComicDetailPresenter();
        presenter.attachView(this);
        presenter.getComicDetaiData(mComicId);
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
    public void getComicsDataSuccess(ComicDetailBean detailBean) {
        if (detailBean != null) {
            ComicDetailBean.DataBean data = detailBean.getData();
            mComicsListFragment.setData(data);
            mComicDetailFragment.setData(data);
            mTvTitle.setText(data.getTitle());
            mTvComicName.setText(data.getTitle());
            mTvLabel.setText(data.getCategory().get(0));
            mImgeCover.setImage(data.getCover_image_url());
            mTvComicTitle.setText(data.getComics().get(0).getTitle());
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @OnClick({R.id.image_back, R.id.tv_comic_title, R.id.tv_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                onBackPressed();
                break;
            case R.id.tv_comic_title:
//                toRaed();
                break;
            case R.id.tv_read:
//                toRaed();
                break;
        }
    }


    private void toRaed() {
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra("comicsId", mComicId);
        startActivity(intent);

    }

    public static void toDetail(Context context, String comicId) {
        Intent intent = new Intent(context, ComicDetailActivity.class);
        intent.putExtra("comicId", comicId);
        context.startActivity(intent);
    }
}
