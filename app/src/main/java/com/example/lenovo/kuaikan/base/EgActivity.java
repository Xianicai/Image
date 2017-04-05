package com.example.lenovo.kuaikan.base;

import android.os.Bundle;

import com.example.lenovo.kuaikan.R;

public class EgActivity extends BaseActivity {


    @Override
    public int getlayoutId() {
//        return R.layout.eg_layout;
        return R.layout.hot_fragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
//        //给TabLayout添加标签
//        for (int i = 0; i < mTitles.length; i++) {
//            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]));
//        }
//        FragmentPagerAdapter fragmentPagerAdapter =
//                new FragmentPagerAdapter(getSupportFragmentManager()) {
//                    @Override
//                    public Fragment getItem(int position) {
//                        Fragment fragment = new Fragment();
//                        switch (position){
////                            case 0:
////                                fragment = new MondayFragment();
////                                break;
////                            case 1:
////                                fragment = new TuesdayFragment();
////                                break;
////                            case 2:
////                                fragment = new ThursdayFragment();
////                                break;
////                            case 3:
////                                fragment = new WednesdayFragment();
////                                break;
////                            case 4:
////                                fragment = new FridayFragment();
////                                break;
////                            case 5:
////                                fragment = new SaturdayFragment();
////                                break;
////                            case 6:
////                                fragment = new DailyFragment();
////                                break;
////                        }
//                        return fragment;
//                    }
//
//                    @Override
//                    public int getCount() {
//                        return mTitles.length;
//                    }
//
//                    @Override
//                    public CharSequence getPageTitle(int position) {
//                        return mTitles[position];
//                    }
//
//                };
//        mViewpager.setAdapter(fragmentPagerAdapter);
//        //将TabLayout与ViewPager绑定在一起
//        mTabLayout.setupWithViewPager(mViewpager);
//    }
//
//    @BindView(R.id.tabLayout)
//    TabLayout mTabLayout;
//    @BindView(R.id.viewpager)
//    ViewPager mViewpager;
//    private String[] mTitles = new String[]{"周三", "周四", "周五", "周六", "周日", "昨天", "今天"};


    }
}

