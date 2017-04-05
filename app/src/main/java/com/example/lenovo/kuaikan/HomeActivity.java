package com.example.lenovo.kuaikan;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.utils.ThemeManagerUtil;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;
    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private CommunityFragment mCommunityFragment;
    private DiscoverFragment mDiscoverFragment;
    private MineFragment mMineFragment;
    private String[] mTitles = new String[]{"漫画", "发现", "V社区", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDefaultFragment();
        //设置状态栏
        ThemeManagerUtil.smartTintManager(this, R.color.yellow);
    }

    @Override
    public int getlayoutId() {
        return R.layout.activity_kuaikan;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mBottomNavigationBar
                .setActiveColor(R.color.yellow)
                .setInActiveColor(R.color.black)
                .setBarBackgroundColor(R.color.white);

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_home_pressed, mTitles[0])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.ic_tabbar_home_normal)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_discover_pressed, mTitles[1])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.ic_tabbar_discover_normal)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_feed_pressed, mTitles[2])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.ic_tabbar_feed_normal)))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tabbar_me_pressed, mTitles[3])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.ic_tabbar_me_normal)))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    private void setDefaultFragment() {

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mHomeFragment = HomeFragment.newInstance();
        transaction.add(R.id.frameLayout, mHomeFragment);
        transaction.commit();

    }



    /**
     * 隐藏当前fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mDiscoverFragment != null) {
            transaction.hide(mDiscoverFragment);
        }
        if (mCommunityFragment != null) {
            transaction.hide(mCommunityFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }


    @Override
    public void onTabSelected(int i) {

        //开启事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragment(transaction);

        /**
         * fragment 用 add + show + hide 方式
         * 只有第一次切换会创建fragment，再次切换不创建
         *
         * fragment 用 replace 方式
         * 每次切换都会重新创建
         *
         */
        switch (i) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                    transaction.add(R.id.frameLayout, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1:

                if (mDiscoverFragment == null) {
                    mDiscoverFragment = DiscoverFragment.newInstance();
                    transaction.add(R.id.frameLayout, mDiscoverFragment);
                } else {
                    transaction.show(mDiscoverFragment);
//                    transaction.show(mHomeFragment);
                }
                break;
            case 2:
                if (mCommunityFragment == null) {
                    mCommunityFragment = CommunityFragment.newInstance();
                    transaction.add(R.id.frameLayout, mCommunityFragment);
                } else {
                    transaction.show(mCommunityFragment);
                }
                break;
            case 3:
                if (mMineFragment == null) {
                    mMineFragment = MineFragment.newInstance();
                    transaction.add(R.id.frameLayout, mMineFragment);
                } else {
                    transaction.show(mMineFragment);
                }
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int i) {

    }

    @Override
    public void onTabReselected(int i) {

    }
}