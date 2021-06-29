package com.luck.picture.lib.photoview;

import android.graphics.RectF;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnMatrixChangedListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Interface definition for a callback to be invoked when the internal Matrix has changed for
 * this View.
 */
public interface OnMatrixChangedListener {

    /**
     * Callback for when the Matrix displaying the Drawable has changed. This could be because
     * the View's bounds have changed, or the user has zoomed.
     *
     * @param rect - Rectangle displaying the Drawable's new bounds.
     */
    void onMatrixChanged(RectF rect);
}
