package com.luck.picture.lib.app;

import android.content.Context;

import com.luck.picture.lib.engine.PictureSelectorEngine;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:IApp.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2019-12-03 15:14
 * @describe：IApp
 */
public interface IApp {
    /**
     * Application
     *
     * @return
     */
    Context getAppContext();

    /**
     * PictureSelectorEngine
     *
     * @return
     */
    PictureSelectorEngine getPictureSelectorEngine();
}
