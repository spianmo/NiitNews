package com.luck.picture.lib.photoview;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnScaleChangedListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Interface definition for callback to be invoked when attached ImageView scale changes
 */
public interface OnScaleChangedListener {

    /**
     * Callback for when the scale changes
     *
     * @param scaleFactor the scale factor (less than 1 for zoom out, greater than 1 for zoom in)
     * @param focusX      focal point X position
     * @param focusY      focal point Y position
     */
    void onScaleChange(float scaleFactor, float focusX, float focusY);
}
