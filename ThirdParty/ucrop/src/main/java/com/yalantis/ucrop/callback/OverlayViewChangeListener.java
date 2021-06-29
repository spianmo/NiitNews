package com.yalantis.ucrop.callback;

import android.graphics.RectF;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OverlayViewChangeListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Created by Oleksii Shliama.
 */
public interface OverlayViewChangeListener {

    void onCropRectUpdated(RectF cropRect);

}