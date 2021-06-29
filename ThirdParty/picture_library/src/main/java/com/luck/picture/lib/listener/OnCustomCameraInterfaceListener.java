package com.luck.picture.lib.listener;

import android.content.Context;

import com.luck.picture.lib.config.PictureSelectionConfig;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnCustomCameraInterfaceListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020/4/27 3:24 PM
 * @describe：OnCustomCameraInterfaceListener
 */
public interface OnCustomCameraInterfaceListener {
    /**
     * Camera Menu
     *
     * @param context
     * @param config
     * @param type
     */
    void onCameraClick(Context context, PictureSelectionConfig config, int type);
}
