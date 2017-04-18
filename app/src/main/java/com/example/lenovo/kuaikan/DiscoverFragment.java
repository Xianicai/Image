package com.example.lenovo.kuaikan;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.discover.ClassifyFragment;
import com.example.lenovo.kuaikan.discover.RecommendFragment;
import com.example.lenovo.kuaikan.utils.RxBus;
import com.example.lenovo.kuaikan.widget.TabAcionBar;

import butterknife.BindView;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment {


    @BindView(R.id.dis_tabActionBar)
    TabAcionBar mTabActionBar;
    @BindView(R.id.dis_viewpager)
    ViewPager mViewpager;
    public static String CHANGE_CURRENT_ITEM = "CHANGE_CURRENT_ITEM";

    public static DiscoverFragment newInstance() {
        return new DiscoverFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_discover;
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
                            return new RecommendFragment();
                        } else {
                            return new ClassifyFragment();

                        }
                    }
                };

        mViewpager.setAdapter(fragmentPagerAdapter);
        mViewpager.setCurrentItem(0);
        mTabActionBar.SetTabActionBarListener(getActivity(), mTabActionBar, mViewpager);

        refreshView();
    }

    private void refreshView() {

        RxBus.getDefault().toObservable(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        if (s.equals(CHANGE_CURRENT_ITEM)) {
                            if (mViewpager != null) {
                                mViewpager.setCurrentItem(1);
                            }
                        }
                    }
                });


    }
}
