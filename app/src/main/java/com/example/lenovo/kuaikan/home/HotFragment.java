package com.example.lenovo.kuaikan.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.home.hot.DailyFragment;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/3/29.
 */

public class HotFragment extends BaseFragment {


    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private String[] mTitles = new String[]{"周三", "周四", "周五", "周六", "周日", "昨天", "今天"};

    @Override
    public int getLayoutId() {
        return R.layout.hot_fragment;
    }

    @Override
    protected void initView(View view) {
        //给TabLayout添加标签
        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]));
        }
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getChildFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {
                         String tabId = "";
                        switch (position) {
                            case 0:
//                                fragment = new MondayFragment();
                                tabId = "1499702400";
                                break;
                            case 1:
//                                fragment = new TuesdayFragment();
                                tabId = "1499788800";
                                break;
                            case 2:
//                                fragment = new ThursdayFragment();
                                tabId = "1499875200";
                                break;
                            case 3:
//                                fragment = new WednesdayFragment();
                                tabId = "1499961600";
                                break;
                            case 4:
//                                fragment = new FridayFragment();
                                tabId = "1500048000";
                                break;
                            case 5:
//                                fragment = new SaturdayFragment();
                                tabId = "1";
                                break;
                            case 6:
                                tabId = "0";
//                                fragment = new DailyFragment();
                                break;
                        }

                        return DailyFragment.newInstance(tabId);
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
        mViewpager.setAdapter(fragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewpager);
        mViewpager.setCurrentItem(6);
    }

}
