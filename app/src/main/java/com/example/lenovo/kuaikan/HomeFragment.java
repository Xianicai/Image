package com.example.lenovo.kuaikan;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.home.HotFragment;
import com.example.lenovo.kuaikan.home.SubscribeFragmen;
import com.example.lenovo.kuaikan.widget.TabAcionBar;

import butterknife.BindView;

/**
 * ZY:漫画Fragment
 * Created by zhanglibin.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.tabActionBar)
    TabAcionBar mTabActionBar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new SubscribeFragmen();
                } else {
                    return new HotFragment();
                }
            }
        };
        mViewpager.setAdapter(fragmentPagerAdapter);
        // 初始化页面为HotFragment
        mViewpager.setCurrentItem(1);
        // mTabActionBar和mViewpager的监听事件
        mTabActionBar.SetTabActionBarListener(getActivity(),mTabActionBar,mViewpager);

    }




}
