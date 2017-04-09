package com.example.lenovo.kuaikan.community;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class SquareFragment extends BaseFragment {

    @BindView(R.id.squar_tabLayout)
    TabLayout mSquarTabLayout;
    @BindView(R.id.squar_viewpager)
    ViewPager mSquarViewpager;
    private String[] mTitles = new String[]{"热门", "最新"};
    @Override
    public int getLayoutId() {
        return R.layout.square_fragment;
    }

    @Override
    protected void initView(View view) {
        //给TabLayout添加标签
        for (int i = 0; i < mTitles.length; i++) {
            mSquarTabLayout.addTab(mSquarTabLayout.newTab().setText(mTitles[i]));
        }
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getChildFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {

                        String catalogType = "";
                        switch (position) {
                            case 0:
                                catalogType = "2";
                                break;
                            case 1:
                                catalogType = "1";
                                break;
                        }

                        return TopicsFragment.newInstance(catalogType);
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
        mSquarViewpager.setAdapter(fragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mSquarTabLayout.setupWithViewPager(mSquarViewpager);
        mSquarViewpager.setCurrentItem(0);
        mSquarViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    TopicsFragment.newInstance("2");
                }else {
                    TopicsFragment.newInstance("1");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
