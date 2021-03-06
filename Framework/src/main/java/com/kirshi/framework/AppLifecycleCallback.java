package com.kirshi.framework;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.kirshi.framework.daemon.DaemonHolder;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:AppLifecycleCallback.java
 * @LastModified:2021/06/29 02:16:29
 */

public class AppLifecycleCallback implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = "AppLifecycleCallback";

    private static final int APP_STATUS_UNKNOWN = -1;
    private static final int APP_STATUS_LIVE = 0;

    private int appStatus = APP_STATUS_UNKNOWN;

    private boolean isForground = true;
    private int appCount = 0;

    private static void startLauncherActivity(Activity activity) {
        try {
            Intent launchIntent = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
            String launcherClassName = launchIntent.getComponent().getClassName();
            String className = activity.getComponentName().getClassName();

            if (TextUtils.isEmpty(launcherClassName) || launcherClassName.equals(className)) {
                return;
            }

            Log.e(TAG, "launcher ClassName --> " + launcherClassName);
            Log.e(TAG, "current ClassName --> " + className);

            launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(launchIntent);
            activity.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        ActivityStackManager.getInstance().addActivity(activity);

        if (appStatus == APP_STATUS_UNKNOWN) {
            appStatus = APP_STATUS_LIVE;
            startLauncherActivity(activity);
        }

        if (savedInstanceState != null && savedInstanceState.getBoolean("saveStateKey", false)) {
            Log.e(TAG, "localTime --> " + savedInstanceState.getLong("localTime"));
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        appCount++;
        if (!isForground) {
            isForground = true;
            Log.e(TAG, "app into forground");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    DaemonHolder.startService();
                }
            }, 8000);
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        // ????????????????????? Activity ??????
        ActivityStackManager.getInstance().setCurrentActivity(activity);
        // Activity ???????????????
        ActivityStackManager.getInstance().setTopActivity(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        appCount--;
        if (!isForgroundAppValue()) {
            isForground = false;
            Log.d(TAG, "app into background ");
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        outState.putBoolean("saveStateKey", true);
        outState.putLong("localTime", System.currentTimeMillis());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ActivityStackManager.getInstance().removeActivity(activity);
    }

    private boolean isForgroundAppValue() {
        return appCount > 0;
    }
}