package com.kirito666.niitnews.net.jar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.google.gson.Gson;
import com.kirito666.niitnews.App;
import com.kirito666.niitnews.entity.User;
import com.kirito666.niitnews.util.Rc4Util;
import com.kirshi.framework.daemon.DaemonHolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:UserJar.java
 * @LastModified:2021/06/29 19:59:29
 */

public class UserJar {
    private static final String CORECONFIG = "user";

    public static boolean isLogin() {
        return loadFromDisk() != null;
    }

    public static User loadFromDisk() {
        Context context = App.Instance();
        try {
            File fs = new File(context.getFilesDir() + File.separator + CORECONFIG);
            FileInputStream is = new FileInputStream(fs);
            byte[] b = new byte[is.available()];
            is.read(b);
            String result = Rc4Util.decode(context, new String(b));
            Log.e("========>", "读取持久化成功，" + result);
            Log.e("========>", new Gson().fromJson(result, User.class).toString());
            return new Gson().fromJson(result, User.class);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static void saveToDisk(User user) {
        App.currentUser = user;
        Context context = App.Instance();
        try {
            File fs = new File(context.getFilesDir() + File.separator + CORECONFIG);
            if (!fs.exists()) {
                fs.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(fs);
            outputStream.write(Rc4Util.encode(context, new Gson().toJson(user)).getBytes());
            Log.e("========>", "持久化到硬盘成功，" + new Gson().toJson(user));
            Log.e("========>", user.toString());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logout() {
        Context context = App.Instance();
        try {
            File fs = new File(context.getFilesDir() + File.separator + CORECONFIG);
            if (fs.exists()) {
                fs.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SessionJar.fireSession();
        if (App.currentUser != null) {
            App.currentUser = null;
        }
        DaemonHolder.stopService();
    }

    public static String getDeviceId(Context context) {
        @SuppressLint("HardwareIds") String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String id = androidID + Build.SERIAL;
        try {
            return toMD5(id).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return id;
        }
    }

    private static String toMD5(String text) throws NoSuchAlgorithmException {
        //获取摘要器 MessageDigest
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        //通过摘要器对字符串的二进制字节数组进行hash计算
        byte[] digest = messageDigest.digest(text.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            //循环每个字符 将计算结果转化为正整数;
            int digestInt = digest[i] & 0xff;
            //将10进制转化为较短的16进制
            String hexString = Integer.toHexString(digestInt);
            //转化结果如果是个位数会省略0,因此判断并补0
            if (hexString.length() < 2) {
                sb.append(0);
            }
            //将循环结果添加到缓冲区
            sb.append(hexString);
        }
        //返回整个结果
        return sb.toString();
    }

}
