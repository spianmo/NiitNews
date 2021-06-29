package com.luck.picture.lib.widget.longimage;

import android.graphics.PointF;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:ImageViewState.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Wraps the scale, center and orientation of a displayed image for easy restoration on screen rotate.
 */
public class ImageViewState implements Serializable {

    private float scale;

    private float centerX;

    private float centerY;

    private int orientation;

    public ImageViewState(float scale, PointF center, int orientation) {
        this.scale = scale;
        this.centerX = center.x;
        this.centerY = center.y;
        this.orientation = orientation;
    }

    public float getScale() {
        return scale;
    }

    public PointF getCenter() {
        return new PointF(centerX, centerY);
    }

    public int getOrientation() {
        return orientation;
    }

}
