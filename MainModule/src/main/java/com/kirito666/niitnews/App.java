package com.kirito666.niitnews;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.net.jar.UserJar;
import com.kirshi.framework.AppLifecycleCallback;
import com.kirshi.framework.BaseApplication;
import com.kirshi.framework.hookapp.AppConfig;
import com.lzf.easyfloat.EasyFloat;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

import jonathanfinerty.once.Once;
import kale.sharelogin.ShareLoginLib;
import kale.sharelogin.qq.QQPlatform;
import kale.sharelogin.utils.MapBuilder;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:App.java
 * @LastModified:2021/06/19 21:50:19
 */

/**
 * @author Finger
 */
public class App extends BaseApplication {

    public static User currentUser;

    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static Context getAppContext() {
        return mApp;
    }

    @Override
    public void addApplications(AppConfig appConfig) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        String packageName = mApp.getPackageName();
        String processName = getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(mApp);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(mApp, "f0114ed064", false);

        this.registerActivityLifecycleCallbacks(new AppLifecycleCallback());
        EasyFloat.init(this, true);
        ShareLoginLib.init(this, getString(R.string.app_name), null, isApkInDebug(mApp));
        ShareLoginLib.initPlatforms(
                MapBuilder.of(
                        QQPlatform.KEY_APP_ID, "101940151",
                        QQPlatform.KEY_SCOPE, "get_user_info,"
                                + "get_simple_userinfo,"
                                + "add_share,"
                                + "add_topic,"
                                + "add_pic_t"
                ),
                Collections.singletonList(
                        QQPlatform.class)
        );
        Once.initialise(this);
        App.currentUser = UserJar.isLogin(mApp) ? UserJar.loadFromDisk(mApp) : null;
    }

    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}


