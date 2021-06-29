package com.yalantis.ucrop.util;

import android.os.Build;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:SdkUtils.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-01-08 20:53
 * @describe：SdkUtils
 */
public class SdkUtils {
    /**
     * 判断是否是Android Q版本
     *
     * @return
     */
    public static boolean isQ() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q;
    }
}
