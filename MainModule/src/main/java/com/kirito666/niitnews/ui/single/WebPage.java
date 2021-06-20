package com.kirito666.niitnews.ui.single;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kirito666.niitnews.databinding.PageWebBinding;
import com.kirshi.framework.BaseActivity;

import java.net.URISyntaxException;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:WebPage.java
 * @LastModified:2021/06/20 00:37:20
 */

/**
 * @author Finger
 */
public class WebPage extends BaseActivity<PageWebBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v.toolbar.setTitle(getIntent().getStringExtra("title"));
        setSupportActionBar(v.toolbar);
        v.toolbar.getBackground().setAlpha(255);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        init();
    }

    public void init() {
        v.webview.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js
        v.webview.getSettings().setJavaScriptEnabled(true);
        v.webview.getSettings().setSavePassword(false);
        v.webview.getSettings().setSaveFormData(false);
        v.webview.getSettings().setSupportZoom(false);
        v.webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) { // Handle the error
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (shouldOverrideUrlLoadingByApp(view, url)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //设置背景颜色 透明
        v.webview.setBackgroundColor(Color.argb(0, 0, 0, 0));
        //载入js
        try {
            v.webview.loadUrl(getIntent().getStringExtra("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean shouldOverrideUrlLoadingByApp(WebView view, String url) {
        if (url.startsWith("http") || url.startsWith("https") || url.startsWith("ftp")) {
            //不处理http, https, ftp的请求
            return false;
        }
        Intent intent;
        try {
            intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
        } catch (URISyntaxException e) {
            return false;
        }
        intent.setComponent(null);
        try {
            this.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LOGE(item.toString());
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
