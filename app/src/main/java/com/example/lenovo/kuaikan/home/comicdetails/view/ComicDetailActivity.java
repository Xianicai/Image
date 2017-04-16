package com.example.lenovo.kuaikan.home.comicdetails.view;

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
import com.example.lenovo.kuaikan.widget.glide.GlideImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private String[] mTitles = new String[]{"详情", "选集"};
    private ComicDetailFragment mComicDetailFragment;
    private ComicsListFragment mComicsListFragment;
    @Override
    public int getlayoutId() {
        return R.layout.activity_comic_detail;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        String comicId = getIntent().getStringExtra("comicId");
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
        presenter.getComicDetaiData(comicId);
    }

    @Override
    public void showMsg(String str) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }

    @Override
    public void getComicsDataSuccess(ComicDetailBean detailBean) {
        if (detailBean != null) {
            ComicDetailBean.DataBean data = detailBean.getData();
            mComicsListFragment.setData(data);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
