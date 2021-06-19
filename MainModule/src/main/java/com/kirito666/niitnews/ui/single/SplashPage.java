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
import com.kirito666.niitnews.ui.MainFrame.MainFrame;
import com.kirshi.framework.mvp.base.BaseActivity;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SplashPage.java
 * @LastModified:2021/06/19 16:51:19
 */

/**
 * @author Finger
 */
public class SplashPage extends BaseActivity<PageSplashBinding> {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        }, 1500);
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
