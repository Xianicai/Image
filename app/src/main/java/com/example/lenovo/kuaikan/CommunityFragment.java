package com.example.lenovo.kuaikan;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.community.SquareFragment;
import com.example.lenovo.kuaikan.home.SubscribeFragmen;
import com.example.lenovo.kuaikan.widget.TabAcionBar;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends BaseFragment {


    @BindView(R.id.com_tabActionBar)
    TabAcionBar mTabActionBar;
    @BindView(R.id.com_viewpager)
    ViewPager mViewpager;

    public static CommunityFragment newInstance() {
        return new CommunityFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_community;
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
                    return new SquareFragment();
                }
            }
        };
        mViewpager.setAdapter(fragmentPagerAdapter);
        mViewpager.setCurrentItem(1);
        mTabActionBar.SetTabActionBarListener(getActivity(),mTabActionBar,mViewpager);
    }


}
