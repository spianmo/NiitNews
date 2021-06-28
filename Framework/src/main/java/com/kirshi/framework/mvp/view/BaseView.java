package com.kirshi.framework.mvp.view;


import com.google.android.material.snackbar.Snackbar;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BaseView.java
 * @LastModified:2021/06/29 02:16:29
 */

public interface BaseView {
    void jumpPage(Class<?> activity);

    void finishself();

    Snackbar showSnackBar(String message);

    void showToast(String message);
}
