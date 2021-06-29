package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yalantis.ucrop.model.ExifInfo;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BitmapLoadCallback.java
 * @LastModified:2021/06/29 17:27:29
 */

public interface BitmapLoadCallback {

    void onBitmapLoaded(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo, @NonNull String imageInputPath, @Nullable String imageOutputPath);

    void onFailure(@NonNull Exception bitmapWorkerException);

}