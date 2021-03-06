package com.luck.picture.lib.photoview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.View;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Compat.java
 * @LastModified:2021/06/29 17:27:29
 */

class Compat {

    private static final int SIXTY_FPS_INTERVAL = 1000 / 60;

    public static void postOnAnimation(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, SIXTY_FPS_INTERVAL);
        }
    }

    @TargetApi(16)
    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
