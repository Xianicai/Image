package com.example.lenovo.kuaikan;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.kuaikan.base.BaseFragment;
import com.example.lenovo.kuaikan.widget.Minilayout;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    @BindView(R.id.img_headportrait)
    ImageView mImgHeadportrait;
    @BindView(R.id.layout_my_message)
    Minilayout mLayoutMyMessage;
    @BindView(R.id.layout_my_follow)
    Minilayout mLayoutMyFollow;
    @BindView(R.id.layout_my_collection)
    Minilayout mLayoutMyCollection;
    @BindView(R.id.layout_kuaikan_game)
    Minilayout mLayoutKuaikanGame;
    @BindView(R.id.layout_kuaikan_mall)
    Minilayout mLayoutKuaikanMall;
    @BindView(R.id.layout_my_order)
    Minilayout mLayoutMyOrder;
    @BindView(R.id.layout_kuaikan_history)
    Minilayout mLayoutKuaikanHistory;
    @BindView(R.id.layout_my_download)
    Minilayout mLayoutMyDownload;
    @BindView(R.id.layout_kuaikan_setup)
    Minilayout mLayoutKuaikanSetup;

    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }


    @Override
    protected void initView(View view) {

    }

    @OnClick(R.id.img_headportrait)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
