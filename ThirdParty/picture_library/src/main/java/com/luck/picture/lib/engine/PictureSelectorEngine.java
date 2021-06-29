package com.luck.picture.lib.engine;

import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:PictureSelectorEngine.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020/4/22 11:36 AM
 * @describe：PictureSelectorEngine
 */
public interface PictureSelectorEngine {

    /**
     * Create ImageLoad Engine
     *
     * @return
     */
    ImageEngine createEngine();

    /**
     * Create Result Listener
     *
     * @return
     */
    OnResultCallbackListener<LocalMedia> getResultCallbackListener();
}
