package com.luck.picture.lib.listener;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnVideoSelectedPlayCallback.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-01-15 14:38
 * @describe：Custom video playback callback
 */
public interface OnVideoSelectedPlayCallback<T> {
    /**
     * Play the video
     *
     * @param data
     */
    void startPlayVideo(T data);
}
