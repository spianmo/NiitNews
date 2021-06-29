package com.luck.picture.lib.instagram;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:Page.java
 * @LastModified:2021/06/29 20:53:29
 */

/**
 * ================================================
 * Created by JessYan on 2020/4/11 17:06
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Page {
    View getView(Context context);

    void refreshData(Context context);

    void init(int position, ViewGroup parent);

    default void onResume() {
    }

    default void onPause() {
    }

    default void onDestroy() {
    }

    String getTitle(Context context);

    default Rect disallowInterceptTouchRect() {
        return null;
    }
}
