package com.kirito666.niitnews.net.jar;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.kirito666.niitnews.App;
import com.kirito666.niitnews.entity.Session;
import com.kirito666.niitnews.util.Rc4Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SessionJar.java
 * @LastModified:2021/06/29 02:16:29
 */

public class SessionJar {
    private static final String CORECONFIG = "session";

    public static boolean isExist() {
        return loadSessionFromDisk() != null;
    }

    public static Session loadSessionFromDisk() {
        Context context = App.getAppContext();
        try {
            File fs = new File(context.getFilesDir() + File.separator + CORECONFIG);
            FileInputStream is = new FileInputStream(fs);
            byte[] b = new byte[is.available()];
            is.read(b);
            String result = Rc4Util.decode(context, new String(b));
            Log.e("========>", "读取持久化成功，" + result);
            Log.e("========>", new Gson().fromJson(result, Session.class).toString());
            return new Gson().fromJson(result, Session.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveSessionToDisk(Session session) {
        Context context = App.getAppContext();
        try {
            File fs = new File(context.getFilesDir() + File.separator + CORECONFIG);
            if (!fs.exists()) {
                fs.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(fs);
            outputStream.write(Rc4Util.encode(context, new Gson().toJson(session)).getBytes());
            Log.e("========>", "持久化到硬盘成功，" + new Gson().toJson(session));
            Log.e("========>", session.toString());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fireSession() {
        Context context = App.getAppContext();
        try {
            File fs = new File(context.getFilesDir() + File.separator + CORECONFIG);
            if (fs.exists()) {
                fs.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
