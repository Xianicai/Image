package com.example.lenovo.kuaikan.utils.js;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.widget.ReadActionBar;

import butterknife.BindView;

public class OutWebActivity extends BaseActivity {


    @BindView(R.id.action_bar)
    ReadActionBar mActionBar;
    @BindView(R.id.outweb)
    WebView mOutweb;

    @Override
    public int getlayoutId() {
        return R.layout.activity_out_web;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        final String webUrl = getIntent().getStringExtra("webUrl");
        String actionBarTitle = getIntent().getStringExtra("actionBarTitle");
        mActionBar.setActionBarTitle(actionBarTitle);
        mOutweb.loadUrl(webUrl);
//        mOutweb.loadUrl("http://www.baidu.com");
        mOutweb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
    }
    public static void toOutWeb(Context context,String webUrl,String title){
        Intent intent = new Intent(context,OutWebActivity.class);
        intent.putExtra("webUrl",webUrl);
        intent.putExtra("actionBarTitle",title);
        context.startActivity(intent);
    }
}
