package com.kirshi.framework.hookapp;

import android.content.Context;
import android.content.res.Configuration;

import androidx.multidex.MultiDexApplication;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:HookApplication.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * Created by guoshiwen on 2017/12/22.
 */

public abstract class HookApplication extends MultiDexApplication {

    public abstract void addApplications(AppConfig appConfig);

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AppManager.init(this);
        addApplications(new AppConfig());
        AppManager.attachBaseContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppManager.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        AppManager.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        AppManager.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        AppManager.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        AppManager.onTrimMemory(level);
    }
}
