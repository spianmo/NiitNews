package com.kirito666.niitnews.ui.single;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kirito666.niitnews.databinding.PageWebBinding;
import com.kirshi.framework.viewbinding.BaseActivity;

import java.net.URISyntaxException;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:WebPage.java
 * @LastModified:2021/06/29 02:16:29
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
        v.webview.getSettings().setSupportMultipleWindows(true);
        v.webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (TextUtils.isEmpty(v.toolbar.getTitle())) {
                    v.toolbar.setTitle(title);
                }
            }

        });
        v.webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (shouldOverrideUrlLoadingByApp(view, url)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        v.webview.setBackgroundColor(Color.argb(0, 0, 0, 0));
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (v.webview.canGoBack()) {
                v.webview.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}
