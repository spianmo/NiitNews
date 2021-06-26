package com.kirshi.framework.databinding;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseAndroidViewModel.java
 * @LastModified:2021/06/24 21:35:24
 */

public class BaseAndroidViewModel extends AndroidViewModel implements LifecycleObserver {
    public BaseAndroidViewModel(@NonNull @NotNull Application application) {
        super(application);
    }
}

