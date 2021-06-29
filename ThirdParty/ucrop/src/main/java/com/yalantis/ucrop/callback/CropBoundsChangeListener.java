package com.yalantis.ucrop.callback;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CropBoundsChangeListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Interface for crop bound change notifying.
 */
public interface CropBoundsChangeListener {

    void onCropAspectRatioChanged(float cropRatio);

}