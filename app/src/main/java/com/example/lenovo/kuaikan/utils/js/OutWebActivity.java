package com.example.lenovo.kuaikan.utils.js;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.widget.ReadActionBar;
import com.pitt.loadingview.library.LoadingView;

import butterknife.BindView;

public class OutWebActivity extends BaseActivity {


    @BindView(R.id.action_bar)
    ReadActionBar mActionBar;
    @BindView(R.id.outweb)
    WebView mOutweb;
    @BindView(R.id.loadingview)
    LoadingView mLoadingview;

    @Override
    public int getlayoutId() {
        return R.layout.activity_out_web;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        final String webUrl = getIntent().getStringExtra("webUrl");
        String actionBarTitle = getIntent().getStringExtra("actionBarTitle");
        mActionBar.setActionBarTitle(actionBarTitle);
        mActionBar.setOnReadActionBarListener(new ReadActionBar.OnReadActionBarListener() {
            @Override
            public void setLeftClickListener() {
                onBackPressed();
            }

            @Override
            public void setRightClickListener() {

            }
        });
        setWebView();
        mOutweb.loadUrl(webUrl);
        //设置在当前的webview加载网页
        mOutweb.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                                         view.loadUrl(webUrl);
                                         return true;
                                     }
                                 }
        );
//        加载框的隐藏和显示
        mOutweb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                // newProgress 1-100
                if (newProgress == 100) {
                    mLoadingview.setVisibility(View.GONE);
                } else {
                    mLoadingview.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setWebView() {
        WebSettings webSettings = mOutweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
    }

    public static void toOutWeb(Context context, String webUrl, String title) {
        Intent intent = new Intent(context, OutWebActivity.class);
        intent.putExtra("webUrl", webUrl);
        intent.putExtra("actionBarTitle", title);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
