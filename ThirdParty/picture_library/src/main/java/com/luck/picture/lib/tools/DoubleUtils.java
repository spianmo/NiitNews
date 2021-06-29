package com.luck.picture.lib.tools;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:DoubleUtils.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.picture.lib.tool
 * email：893855882@qq.com
 * data：2017/5/25
 */

public class DoubleUtils {
    /**
     * Prevent continuous click, jump two pages
     */
    private static long lastClickTime;
    private final static long TIME = 800;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
