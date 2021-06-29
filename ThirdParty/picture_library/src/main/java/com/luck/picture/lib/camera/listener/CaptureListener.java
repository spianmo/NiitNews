package com.luck.picture.lib.camera.listener;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CaptureListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * @author：luck
 * @date：2020-01-04 13:56
 */
public interface CaptureListener {
    void takePictures();

    void recordShort(long time);

    void recordStart();

    void recordEnd(long time);

    void recordZoom(float zoom);

    void recordError();
}
