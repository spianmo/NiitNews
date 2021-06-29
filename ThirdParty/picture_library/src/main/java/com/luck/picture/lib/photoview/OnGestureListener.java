package com.luck.picture.lib.photoview;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnGestureListener.java
 * @LastModified:2021/06/29 17:27:29
 */

interface OnGestureListener {

    void onDrag(float dx, float dy);

    void onFling(float startX, float startY, float velocityX,
                 float velocityY);

    void onScale(float scaleFactor, float focusX, float focusY);

}