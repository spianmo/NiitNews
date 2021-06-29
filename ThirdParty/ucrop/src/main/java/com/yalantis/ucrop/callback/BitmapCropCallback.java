package com.yalantis.ucrop.callback;

import android.net.Uri;

import androidx.annotation.NonNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BitmapCropCallback.java
 * @LastModified:2021/06/29 17:27:29
 */

public interface BitmapCropCallback {

    void onBitmapCropped(@NonNull Uri resultUri, int offsetX, int offsetY, int imageWidth, int imageHeight);

    void onCropFailure(@NonNull Throwable t);

}