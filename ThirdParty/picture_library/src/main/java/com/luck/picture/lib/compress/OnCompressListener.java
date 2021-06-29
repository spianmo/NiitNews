package com.luck.picture.lib.compress;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnCompressListener.java
 * @LastModified:2021/06/29 17:27:29
 */

public interface OnCompressListener {

    /**
     * Fired when the compression is started, override to handle in your own code
     */
    void onStart();

    /**
     * Fired when a compression returns successfully, override to handle in your own code
     */
    void onSuccess(List<LocalMedia> list);

    /**
     * Fired when a compression fails to complete, override to handle in your own code
     */
    void onError(Throwable e);
}
