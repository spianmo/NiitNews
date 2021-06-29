package com.kirito666.niitnews;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;

import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.net.jar.UserJar;
import com.kirito666.niitnews.util.PictureSelectorEngineImp;
import com.kirshi.framework.AppLifecycleCallback;
import com.kirshi.framework.BaseApplication;
import com.kirshi.framework.hookapp.AppConfig;
import com.luck.picture.lib.app.IApp;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.crash.PictureSelectorCrashUtils;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.lzf.easyfloat.EasyFloat;
import com.tencent.bugly.crashreport.CrashReport;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import jonathanfinerty.once.Once;
import kale.sharelogin.ShareLoginLib;
import kale.sharelogin.qq.QQPlatform;
import kale.sharelogin.utils.MapBuilder;
import okhttp3.OkHttpClient;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:App.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * @author Finger
 */
public class App extends BaseApplication implements IApp, CameraXConfig.Provider {

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


    public static Context Instance() {
        return mApp;
    }

    @Override
    public Context getAppContext() {
        return this;
    }

    @Override
    public PictureSelectorEngine getPictureSelectorEngine() {
        return new PictureSelectorEngineImp();
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
        CrashReport.initCrashReport(mApp, "977e66581f", false);

        this.registerActivityLifecycleCallbacks(new AppLifecycleCallback());
        EasyFloat.init(this, true);
        ShareLoginLib.init(this, getString(R.string.app_name), null, isApkInDebug(mApp));
        ShareLoginLib.initPlatforms(
                MapBuilder.of(
                        QQPlatform.KEY_APP_ID, "101959662",
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
        App.currentUser = UserJar.isLogin() ? UserJar.loadFromDisk() : null;

        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                .build();

        OkHttpUtils.initClient(okHttpClient);

        PictureAppMaster.getInstance().setApp(this);
        // PictureSelector Crash日志监听
        PictureSelectorCrashUtils.init((t, e) -> {
            // Crash之后的一些操作可再此处理，没有就忽略...

        });
    }

    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLogin() {
        return currentUser != null;
    }

    @NonNull
    @Override
    public CameraXConfig getCameraXConfig() {
        return Camera2Config.defaultConfig();
    }

}


