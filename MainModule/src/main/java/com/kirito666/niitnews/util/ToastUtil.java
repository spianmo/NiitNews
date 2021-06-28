package com.kirito666.niitnews.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ToastUtil.java
 * @LastModified:2021/06/29 02:16:29
 */

/**
 * 提示工具类
 * Created by burro on 2017/9/23.
 */
public class ToastUtil {
    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        }
    };

    /**
     * 提示
     *
     * @param mContext
     * @param text     String 内容
     */
    public static void showToast(Context mContext, String text) {
        if (!StringUtil.isStrEmpty(text)) {
            if (mToast != null)
                mToast.setText(text.trim());
            else
                mToast = Toast.makeText(mContext, text.trim(), Toast.LENGTH_SHORT);
            mToast.show();
        }
    }


    public static void showToast(Context mContext, String text, int duration) {
        if (!StringUtil.isStrEmpty(text)) {
            mHandler.removeCallbacks(r);
            if (mToast != null)
                mToast.setText(text);
            else
                mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
            mHandler.postDelayed(r, duration);

            mToast.show();
        }
    }

    public static void showToast(Context mContext, int resId, int duration) {
        showToast(mContext, mContext.getResources().getString(resId), duration);
    }
}
