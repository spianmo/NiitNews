package com.kirshi.framework;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.kirshi.framework.hookapp.HookApplication;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseApplication.java
 * @LastModified:2021/06/29 02:16:29
 */

public abstract class BaseApplication extends HookApplication {
    private static BaseApplication instance;
    protected static Context mApp;


    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mApp = instance.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
