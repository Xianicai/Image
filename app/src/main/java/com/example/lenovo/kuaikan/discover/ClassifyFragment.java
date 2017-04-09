package com.example.lenovo.kuaikan.discover;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.discover.classify.BeanContent;
import com.example.lenovo.kuaikan.discover.classify.CentreFragment;
import com.example.lenovo.kuaikan.discover.classify.ReqContent;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class ClassifyFragment extends BaseFragment {
    @BindView(R.id.classify_tabLayout)
    TabLayout mClassifyTabLayout;
    @BindView(R.id.imge_select_classify)
    ImageView mImgeSelectClassify;
    @BindView(R.id.classify_viewpager)
    ViewPager mClassifyViewpager;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private List<BeanContent.DataBean.TagsBean> mTags;

    @Override
    public int getLayoutId() {
        return R.layout.classify_fragment;
    }

    @Override
    protected void initView(View view) {

        getServerData();

    }

    @NonNull
    private FragmentPagerAdapter getFragmentPagerAdapter(final List<BeanContent.DataBean.TagsBean> tags) {
        return new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public int getCount() {
                    return tags.size();
                }

                @Override
                public Fragment getItem(int position) {
                    String tag= "";
                    switch (position) {
                        case 0:
                            tag = tags.get(0).getTag_id()+"";
                            break;
                        case 1:
                            tag = tags.get(1).getTag_id()+"";
                            break;
                        case 2:
                            tag = tags.get(2).getTag_id()+"";
                            break;
                        case 3:
                            tag = tags.get(3).getTag_id()+"";
                            break;
                        case 4:
                            tag = tags.get(4).getTag_id()+"";
                            break;
                        case 5:
                            tag = tags.get(5).getTag_id()+"";
                            break;
                        case 6:
                            tag = tags.get(6).getTag_id()+"";
                            break;
                        case 7:
                            tag = tags.get(7).getTag_id()+"";
                            break;
                        case 8:
                            tag = tags.get(8).getTag_id()+"";
                            break;
                        case 9:
                            tag = tags.get(9).getTag_id()+"";
                            break;
                        case 10:
                            tag = tags.get(10).getTag_id()+"";
                            break;
                        case 11:
                            tag = tags.get(11).getTag_id()+"";
                            break;
                    }
                    return CentreFragment.newInstance(tag);
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return  tags.get(position).getTitle();
                }
            };
    }

    private void getServerData() {
        final ReqContent req = new ReqContent();
        String url = Urls.parse(Urls.DISCOVER_CLASSIFY,"0","0","1");
        NetAsynTask.connectByGet(url, null, req, new NetAsynTask.CallBack() {
            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    BeanContent beanContent = req.getT();
                    mTags = beanContent.getData().getTags();
                    for (int i = 0; i < mTags.size(); i++) {
                        mClassifyTabLayout.addTab(mClassifyTabLayout.newTab().setText(mTags.get(i).getTitle()));
                    }
                    mFragmentPagerAdapter = getFragmentPagerAdapter(mTags);
                    mClassifyViewpager.setAdapter(mFragmentPagerAdapter);
                    //将TabLayout与ViewPager绑定在一起
                    mClassifyTabLayout.setupWithViewPager(mClassifyViewpager);
                }
            }

            @Override
            public void onGetFinished() {

            }

            @Override
            public void onGetFaild() {

            }

            @Override
            public void onGetError() {

            }
        });
    }
}
