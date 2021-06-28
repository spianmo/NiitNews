package com.kirito666.niitnews.ui.single;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.kirito666.niitnews.databinding.PageSplashBinding;
import com.kirito666.niitnews.ui.main_frame.MainFrame;
import com.kirshi.framework.viewbinding.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SplashPage.java
 * @LastModified:2021/06/29 02:16:29
 */

/**
 * @author Finger
 */
public class SplashPage extends BaseActivity<PageSplashBinding> {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getOneTalk();
        Glide.with(mContext).load("https://cn.bing.com/ImageResolution.aspx?w=1080&h=2340&toWww=1").into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                v.root.setBackground(resource);
            }
        });
        v.tvVersion.setText("Verison:" + getLocalVersionName(mContext));
        new Handler(getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashPage.this, MainFrame.class);
            startActivity(intent);
            finish();
        }, 1200);
    }

    /**
     * 一言接口
     * https://developer.hitokoto.cn/sentence/#%E8%AF%B7%E6%B1%82%E5%8F%82%E6%95%B0
     */
    private void getOneTalk() {
        String url = "https://v1.hitokoto.cn/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("c", "k")
                .addParams("encode", "text")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        v.tvOnetalk.setText("@" + response);
                    }
                });
    }

    public static int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 获取本地软件版本号名称
     */
    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }
}
