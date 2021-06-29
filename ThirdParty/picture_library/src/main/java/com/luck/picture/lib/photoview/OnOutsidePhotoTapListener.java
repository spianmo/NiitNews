package com.luck.picture.lib.photoview;

import android.widget.ImageView;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:OnOutsidePhotoTapListener.java
 * @LastModified:2021/06/29 17:27:29
 */

/**
 * Callback when the user tapped outside of the photo
 */
public interface OnOutsidePhotoTapListener {

    /**
     * The outside of the photo has been tapped
     */
    void onOutsidePhotoTap(ImageView imageView);
}
